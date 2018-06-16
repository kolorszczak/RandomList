package eu.mihau.randomlist.viewmodel;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import eu.mihau.randomlist.model.Element;
import eu.mihau.randomlist.utils.provider.interval.AppIntervalProvider;
import eu.mihau.randomlist.utils.provider.random.RandomProvider;
import eu.mihau.randomlist.utils.provider.scheduler.SchedulerProvider;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

public class MainViewModel extends ViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();

    public PublishSubject<RandomEvent> randomEventPublishSubject = PublishSubject.create();

    private List<Element> list = new ArrayList<>();

    private SchedulerProvider schedulerProvider;
    private AppIntervalProvider intervalProvider;
    private RandomProvider randomProvider;

    @Inject
    public MainViewModel(SchedulerProvider schedulerProvider, AppIntervalProvider intervalProvider, RandomProvider randomProvider) {
        this.schedulerProvider = schedulerProvider;
        this.intervalProvider = intervalProvider;
        this.randomProvider = randomProvider;
    }

    public void start() {
        intervalProvider.onStart();
        handleInterval();
    }

    public void stop() {
        if (intervalProvider.isDisposed()) {
            randomEventPublishSubject.onNext(new RandomEvent(RandomEvent.Type.CLEAR, 0, null));
        }
        intervalProvider.onStop();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        intervalProvider.disposable.dispose();
    }

    @SuppressLint("CheckResult")
    private void handleInterval() {
        intervalProvider.intervalSubject
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(interval -> {
                    if (list.size() < 5) {
                        Element element = new Element(interval, randomProvider.getColor());
                        list.add(element);
                        randomEventPublishSubject.onNext(new RandomEvent(RandomEvent.Type.CREATE, list.size() - 1, element));
                        Log.d(TAG, "NEW element");
                    } else {
                        Integer randomPosition = randomProvider.getPercent() % list.size();
                        Element randomElement = list.get(randomPosition);
                        if (isInRange(randomProvider.getPercent(), 0, 49)) {
                            Log.d(TAG, "+1 to counter of " + randomPosition + " element");
                            randomElement.setCounter(randomElement.getCounter() + 1L);
                            randomEventPublishSubject.onNext(new RandomEvent(RandomEvent.Type.UPDATE, randomPosition, randomElement));
                        } else if (isInRange(randomProvider.getPercent(), 50, 85)) {
                            Log.d(TAG, "RESET counter of " + randomPosition + " element");
                            randomElement.setCounter(0L);
                            randomEventPublishSubject.onNext(new RandomEvent(RandomEvent.Type.UPDATE, randomPosition, randomElement));
                        } else if (isInRange(randomProvider.getPercent(), 86, 95)) {
                            Log.d(TAG, "DELETE " + randomPosition + " element");
                            list.remove(randomElement);
                            randomEventPublishSubject.onNext(new RandomEvent(RandomEvent.Type.DELETE, randomPosition, randomElement));
                        } else if (isInRange(randomProvider.getPercent(), 96, 100)) {
                            Log.d(TAG, "SUM counters of " + randomPosition + " and " + (randomPosition == 0 ? list.size() - 1 : randomPosition - 1) + " elements");
                            randomElement.setCounter(randomElement.getCounter() + list.get(randomPosition == 0 ? list.size() - 1 : randomPosition - 1).getCounter());
                            randomEventPublishSubject.onNext(new RandomEvent(RandomEvent.Type.UPDATE, randomPosition, randomElement));
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }

    private boolean isInRange(Integer value, Integer min, Integer max) {
        return value >= min && value <= max;
    }
}
