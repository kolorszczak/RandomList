package eu.mihau.randomlist.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import eu.mihau.randomlist.view.ListActivity;
import eu.mihau.randomlist.view.MainActivity;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract ListActivity bindListActivity();
}
