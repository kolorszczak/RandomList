package eu.mihau.randomlist.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.Collections;

import eu.mihau.randomlist.R;
import eu.mihau.randomlist.base.BaseActivity;
import eu.mihau.randomlist.utils.list.item.PaletteItem;

public class ListActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private FastAdapter fastAdapter = FastAdapter.with(Collections.singletonList(itemAdapter = new ItemAdapter<>()));
    private ItemAdapter<PaletteItem> itemAdapter;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(fastAdapter);

        itemAdapter.add(new PaletteItem(R.drawable.merchant_1));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_2));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_3));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_4));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_5));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_6));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_7));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_8));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_9));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_10));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_11));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_12));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_13));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_14));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_15));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_16));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_17));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_18));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_19));
        itemAdapter.add(new PaletteItem(R.drawable.merchant_20));

    }
}
