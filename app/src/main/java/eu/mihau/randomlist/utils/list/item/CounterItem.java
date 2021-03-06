package eu.mihau.randomlist.utils.list.item;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import eu.mihau.randomlist.R;
import eu.mihau.randomlist.databinding.ItemCounterBinding;
import eu.mihau.randomlist.model.Element;

public class CounterItem extends AbstractItem<CounterItem, CounterItem.ViewHolder> {

    Element element;

    public CounterItem(Element element) {
        this.element = element;
    }

    public CounterItem() {
        this.element = new Element(100L, R.color.colorPrimary);
    }

    @Override
    public int getType() {
        return R.id.item_counter;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_counter;
    }

    @Override
    public void bindView(@NonNull CounterItem.ViewHolder holder, @NonNull List<Object> payloads) {
        super.bindView(holder, payloads);
        holder.binding.setElement(element);
    }

    @NonNull
    @Override
    public CounterItem.ViewHolder getViewHolder(View v) {
        return new CounterItem.ViewHolder(v);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ItemCounterBinding binding;

        ViewHolder(View view) {
            super(view);
            binding = ItemCounterBinding.bind(itemView);
        }
    }
}