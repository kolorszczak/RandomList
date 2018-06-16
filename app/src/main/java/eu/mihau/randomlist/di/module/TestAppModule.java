package eu.mihau.randomlist.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import eu.mihau.randomlist.utils.provider.interval.AppIntervalProvider;
import eu.mihau.randomlist.utils.provider.random.AppRandomProvider;
import eu.mihau.randomlist.utils.provider.random.RandomProvider;
import eu.mihau.randomlist.utils.provider.scheduler.AppSchedulerProvider;
import eu.mihau.randomlist.utils.provider.scheduler.SchedulerProvider;

@Module
public class TestAppModule {

    @Provides
    @Singleton
    RandomProvider provideRandomProvider() {
        return new AppRandomProvider();
    }

    @Provides
    @Singleton
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    AppIntervalProvider provideIntervalProvider(SchedulerProvider schedulerProvider) {
        return new AppIntervalProvider(schedulerProvider);
    }
}
