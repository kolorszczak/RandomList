package eu.mihau.randomlist.utils.provider.interval;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import eu.mihau.randomlist.utils.provider.scheduler.SchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

//https://medium.com/@CodyEngel/managing-disposables-in-rxjava-2-for-android-388722ae1e8a
public class AppIntervalProvider {

    public PublishSubject<Long> intervalSubject = PublishSubject.create();
    private CompositeDisposable disposable = new CompositeDisposable();

    private Long currentInterval = 0L;
    private SchedulerProvider schedulerProvider;

    @Inject
    public AppIntervalProvider(SchedulerProvider schedulerProvider) {
        this.schedulerProvider = schedulerProvider;
    }

    public void onStart() {
        disposable.dispose();
        disposable = new CompositeDisposable(Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(l -> intervalSubject.onNext(currentInterval++),
                        Throwable::printStackTrace));
    }

    public void onStop() {
        if (disposable.isDisposed()) {
            currentInterval = 0L;
        }
        disposable.dispose();
    }

    public boolean isDisposed() {
        return disposable.isDisposed();
    }
}
