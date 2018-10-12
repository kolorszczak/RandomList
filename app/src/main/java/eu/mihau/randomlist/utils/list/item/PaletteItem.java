package eu.mihau.randomlist.utils.list.item;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import eu.mihau.randomlist.R;

public class PaletteItem extends AbstractItem<PaletteItem, PaletteItem.ViewHolder> {

    @DrawableRes
    private Integer drawable;

    public PaletteItem(@DrawableRes Integer drawable) {
        this.drawable = drawable;
    }

    @Override
    public int getType() {
        return R.id.item_palette;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_palette;
    }

    @Override
    public void bindView(@NonNull PaletteItem.ViewHolder holder, @NonNull List<Object> payloads) {
        super.bindView(holder, payloads);
        Glide.with(holder.itemView.getContext())
                .load(drawable)
                .into(holder.image);

        setupPalette(holder);
    }

    private void setupPalette(ViewHolder holder) {
        Glide.with(holder.itemView.getContext())
                .asBitmap()
                .load(drawable)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        setupLabels(holder, resource);
                    }
                });
    }

    private void setupLabels(ViewHolder holder, Bitmap bitmap) {
        Palette.from(bitmap).generate(palette -> {
            holder.lay0.setBackgroundColor(getContrastColor(palette.getDominantColor(Color.RED)));
            holder.row0a.setTextColor(palette.getDominantSwatch() != null ? getContrastColor(palette.getDominantSwatch().getTitleTextColor()) : Color.RED);
            holder.row0b.setTextColor(palette.getDominantSwatch() != null ? getContrastColor(palette.getDominantSwatch().getBodyTextColor()) : Color.RED);

            holder.lay1.setBackgroundColor(palette.getDominantColor(Color.RED));
            holder.row1a.setTextColor(palette.getDominantSwatch() != null ? palette.getDominantSwatch().getTitleTextColor() : Color.RED);
            holder.row1b.setTextColor(palette.getDominantSwatch() != null ? palette.getDominantSwatch().getBodyTextColor() : Color.RED);

            holder.lay2.setBackgroundColor(palette.getMutedColor(Color.RED));
            holder.row2a.setTextColor(palette.getMutedSwatch() != null ? palette.getMutedSwatch().getTitleTextColor() : Color.RED);
            holder.row2b.setTextColor(palette.getMutedSwatch() != null ? palette.getMutedSwatch().getBodyTextColor() : Color.RED);

            holder.lay3.setBackgroundColor(palette.getVibrantColor(Color.RED));
            holder.row3a.setTextColor(palette.getVibrantSwatch() != null ? palette.getVibrantSwatch().getTitleTextColor() : Color.RED);
            holder.row3b.setTextColor(palette.getVibrantSwatch() != null ? palette.getVibrantSwatch().getBodyTextColor() : Color.RED);

            holder.lay4.setBackgroundColor(palette.getDarkMutedColor(Color.RED));
            holder.row4a.setTextColor(palette.getDarkMutedSwatch() != null ? palette.getDarkMutedSwatch().getTitleTextColor() : Color.RED);
            holder.row4b.setTextColor(palette.getDarkMutedSwatch() != null ? palette.getDarkMutedSwatch().getBodyTextColor() : Color.RED);

            holder.lay5.setBackgroundColor(palette.getDarkVibrantColor(Color.RED));
            holder.row5a.setTextColor(palette.getDarkVibrantSwatch() != null ? palette.getDarkVibrantSwatch().getTitleTextColor() : Color.RED);
            holder.row5b.setTextColor(palette.getDarkVibrantSwatch() != null ? palette.getDarkVibrantSwatch().getBodyTextColor() : Color.RED);

            holder.lay6.setBackgroundColor(palette.getLightMutedColor(Color.RED));
            holder.row6a.setTextColor(palette.getLightMutedSwatch() != null ? palette.getLightMutedSwatch().getTitleTextColor() : Color.RED);
            holder.row6b.setTextColor(palette.getLightMutedSwatch() != null ? palette.getLightMutedSwatch().getBodyTextColor() : Color.RED);

            holder.lay7.setBackgroundColor(palette.getLightVibrantColor(Color.RED));
            holder.row7a.setTextColor(palette.getLightVibrantSwatch() != null ? palette.getLightVibrantSwatch().getTitleTextColor() : Color.RED);
            holder.row7b.setTextColor(palette.getLightVibrantSwatch() != null ? palette.getLightVibrantSwatch().getBodyTextColor() : Color.RED);

        });
    }

    private Integer getContrastColor(int color) {
        return Color.rgb(255-Color.red(color),
                255-Color.green(color),
                255-Color.blue(color));
    }

    @NonNull
    @Override
    public PaletteItem.ViewHolder getViewHolder(View v) {
        return new PaletteItem.ViewHolder(v);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView row0a, row0b, row1a, row1b, row2a, row2b, row3a, row3b, row4a, row4b, row5a, row5b, row6a, row6b, row7a, row7b;
        LinearLayout lay0, lay1, lay2, lay3, lay4, lay5, lay6, lay7;

        ViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.image);
            row0a = view.findViewById(R.id.row0a);
            row1a = view.findViewById(R.id.row1a);
            row2a = view.findViewById(R.id.row2a);
            row3a = view.findViewById(R.id.row3a);
            row4a = view.findViewById(R.id.row4a);
            row5a = view.findViewById(R.id.row5a);
            row6a = view.findViewById(R.id.row6a);
            row7a = view.findViewById(R.id.row7a);
            row0b = view.findViewById(R.id.row0b);
            row1b = view.findViewById(R.id.row1b);
            row2b = view.findViewById(R.id.row2b);
            row3b = view.findViewById(R.id.row3b);
            row4b = view.findViewById(R.id.row4b);
            row5b = view.findViewById(R.id.row5b);
            row6b = view.findViewById(R.id.row6b);
            row7b = view.findViewById(R.id.row7b);
            lay0 = view.findViewById(R.id.lay0);
            lay1 = view.findViewById(R.id.lay1);
            lay2 = view.findViewById(R.id.lay2);
            lay3 = view.findViewById(R.id.lay3);
            lay4 = view.findViewById(R.id.lay4);
            lay5 = view.findViewById(R.id.lay5);
            lay6 = view.findViewById(R.id.lay6);
            lay7 = view.findViewById(R.id.lay7);
        }
    }
}
