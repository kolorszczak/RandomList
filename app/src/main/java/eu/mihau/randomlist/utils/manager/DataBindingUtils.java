package eu.mihau.randomlist.utils.manager;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import eu.mihau.randomlist.utils.list.SeparatorItemDecorator;

public class DataBindingUtils {

    @BindingAdapter(value = {"itemDecorator"})
    public static void setItemDecorator(RecyclerView view, Drawable drawable) {
        if (view.getItemDecorationCount() > 0) {
            for (int i = 0; i < view.getItemDecorationCount(); i++) {
                view.removeItemDecorationAt(i);
            }
        }
        view.addItemDecoration(new SeparatorItemDecorator(drawable));
    }

    @BindingAdapter(value = {"backgroundTint"})
    public static void setBackgroundTint(ImageView view, Integer tint) {
        view.setBackgroundTintList(ContextCompat.getColorStateList(view.getContext(), tint));
    }
}
