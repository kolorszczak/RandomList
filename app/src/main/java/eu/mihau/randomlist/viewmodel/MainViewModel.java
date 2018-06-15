package eu.mihau.randomlist.viewmodel;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import eu.mihau.randomlist.utils.provider.resource.ResourceProvider;

public class MainViewModel extends ViewModel {

    private ResourceProvider resourcesProvider;

    @Inject
    public MainViewModel(ResourceProvider resourcesProvider) {
        this.resourcesProvider = resourcesProvider;
    }
}
