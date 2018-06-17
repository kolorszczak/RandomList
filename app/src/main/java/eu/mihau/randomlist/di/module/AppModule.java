package eu.mihau.randomlist.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import eu.mihau.randomlist.utils.provider.interval.AppIntervalProvider;
import eu.mihau.randomlist.utils.provider.random.AppRandomProvider;
import eu.mihau.randomlist.utils.provider.random.RandomProvider;
import eu.mihau.randomlist.utils.provider.scheduler.AppSchedulerProvider;
import eu.mihau.randomlist.utils.provider.scheduler.SchedulerProvider;
import eu.mihau.randomlist.viewmodel.ViewModelFactory;

@Module
public class AppModule {

    Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }

    @Provides
    Context provideContext() {
        return app;
    }

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

    @Provides
    @Singleton
    ViewModelFactory provideViewModelFactory(SchedulerProvider schedulerProvider, RandomProvider randomProvider) {
        return new ViewModelFactory(schedulerProvider, randomProvider);
    }
}
