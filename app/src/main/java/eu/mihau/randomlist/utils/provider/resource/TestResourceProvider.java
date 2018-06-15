package eu.mihau.randomlist.utils.provider.resource;


import android.graphics.Color;

import dagger.Module;

@Module
public class TestResourceProvider implements ResourceProvider {
    @Override
    public int getColor(int resId) {
        return Color.RED;
    }
}
