package eu.mihau.randomlist.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import javax.inject.Inject;

import eu.mihau.randomlist.utils.provider.resource.ResourceProvider;

public class MainViewModel extends ViewModel {

    public ObservableField<String> diTest = new ObservableField<>();

    private ResourceProvider resourcesProvider;

    @Inject
    public MainViewModel(ResourceProvider resourcesProvider) {
        this.resourcesProvider = resourcesProvider;
        this.diTest.set("DI & DB setup success");
    }
}
