package eu.mihau.randomlist;

import com.facebook.stetho.Stetho;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import eu.mihau.randomlist.di.component.AppComponent;
import eu.mihau.randomlist.di.component.DaggerAppComponent;
import eu.mihau.randomlist.di.module.AppModule;

public class RandomListApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
        return appComponent;
    }
}
