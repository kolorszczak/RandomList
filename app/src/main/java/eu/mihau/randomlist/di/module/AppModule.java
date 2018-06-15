package eu.mihau.randomlist.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import eu.mihau.randomlist.utils.provider.resource.AppResourceProvider;
import eu.mihau.randomlist.utils.provider.resource.ResourceProvider;
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
    ViewModelFactory provideViewModelFactory(ResourceProvider resourceProvider) {
        return new ViewModelFactory(resourceProvider);
    }

    @Provides
    @Singleton
    ResourceProvider provideResourceProvider() {
        return new AppResourceProvider(app);
    }

    @Provides
    @Singleton
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
