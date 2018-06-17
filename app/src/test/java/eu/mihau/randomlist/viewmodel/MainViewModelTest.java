package eu.mihau.randomlist.viewmodel;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import eu.mihau.randomlist.R;
import eu.mihau.randomlist.model.Element;
import eu.mihau.randomlist.utils.provider.random.TestRandomProvider;
import eu.mihau.randomlist.utils.provider.scheduler.TestSchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

public class MainViewModelTest {

    private MainViewModel mainViewModel;
    private TestSchedulerProvider schedulerProvider;

    @Before
    public void before() {
        schedulerProvider = new TestSchedulerProvider();
        TestRandomProvider testRandomProvider = new TestRandomProvider();
        mainViewModel = new MainViewModel(schedulerProvider, testRandomProvider);
    }

    @Test
    public void handleIntervalTest() {
        ArrayList<RandomEvent> sequence = new ArrayList<>();
        sequence.add(new RandomEvent(RandomEvent.Type.CREATE, 0, new Element(1, R.color.md_red_500)));
        sequence.add(new RandomEvent(RandomEvent.Type.CREATE, 1, new Element(0, R.color.md_red_500)));
        sequence.add(new RandomEvent(RandomEvent.Type.CREATE, 2, new Element(2, R.color.md_red_500)));
        sequence.add(new RandomEvent(RandomEvent.Type.CREATE, 3, new Element(3, R.color.md_red_500)));
        sequence.add(new RandomEvent(RandomEvent.Type.CREATE, 4, new Element(5, R.color.md_red_500)));
        sequence.add(new RandomEvent(RandomEvent.Type.UPDATE, 4, new Element(5, R.color.md_red_500)));
        sequence.add(new RandomEvent(RandomEvent.Type.UPDATE, 1, new Element(0, R.color.md_red_500)));
        sequence.add(new RandomEvent(RandomEvent.Type.DELETE, 3, new Element(3, R.color.md_red_500)));
        sequence.add(new RandomEvent(RandomEvent.Type.CREATE, 4, new Element(8, R.color.md_red_500)));
        sequence.add(new RandomEvent(RandomEvent.Type.UPDATE, 0, new Element(1, R.color.md_red_500)));

        TestObserver<RandomEvent> observer = mainViewModel.randomEventPublishSubject
                .observeOn(schedulerProvider.io())
                .subscribeOn(schedulerProvider.ui())
                .test();

        Observable.intervalRange(0, 10, 0, 10, TimeUnit.MILLISECONDS)
                .subscribe(aLong -> {
                    mainViewModel.handleInterval(aLong);
                });

        observer.awaitCount(10);
        observer.assertValueSequence(sequence);
        observer.assertNoErrors();
    }
}