package eu.mihau.randomlist.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import javax.inject.Inject;

import eu.mihau.randomlist.utils.provider.resource.ResourceProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    public ResourceProvider resourcesProvider;

    @Inject
    public ViewModelFactory(ResourceProvider resourcesProvider) {
        this.resourcesProvider = resourcesProvider;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(resourcesProvider);
        }
        throw new RuntimeException("Unknown viewModel class");
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T get(@NonNull Class<T> modelClass, FragmentActivity activity) {
        return ViewModelProviders.of(activity, this).get(modelClass);
    }

}