package eu.mihau.randomlist.utils.provider.resource;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import javax.inject.Inject;


public class AppResourceProvider implements ResourceProvider {

    private Context context;

    @Inject
    public AppResourceProvider(Context context) {
        this.context = context;
    }

    @Override
    public int getColor(int resId) {
        return ContextCompat.getColor(context, resId);
    }
}