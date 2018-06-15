package eu.mihau.randomlist.utils.provider.resource;

import android.support.annotation.ColorRes;

public interface ResourceProvider {

    int getColor(@ColorRes int resId);
}