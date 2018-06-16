package eu.mihau.randomlist.utils.manager;

import android.databinding.BindingAdapter;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import eu.mihau.randomlist.utils.list.SeparatorItemDecorator;

public class DataBindingUtils {

    @BindingAdapter(value = {"itemDecorator"})
    public static void setItemDecorator(RecyclerView view, Integer drawable) {
        if (view.getItemDecorationCount() > 0) {
            for (int i = 0; i < view.getItemDecorationCount(); i++) {
                view.removeItemDecorationAt(i);
            }
        }
        view.addItemDecoration(new SeparatorItemDecorator(ContextCompat.getDrawable(view.getContext(), drawable)));
    }

    @BindingAdapter(value = {"backgroundTint"})
    public static void setBackgroundTint(ImageView view, @ColorRes Integer tint) {
        view.setBackgroundTintList(ContextCompat.getColorStateList(view.getContext(), tint));
    }


    @BindingAdapter("android:text")
    public static void setLong(TextView view, Long value) {
        if (value == null)
            return;
        view.setText(String.valueOf(value));
    }
}
