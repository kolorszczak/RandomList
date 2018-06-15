package eu.mihau.randomlist.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.Collections;

import javax.inject.Inject;

import eu.mihau.randomlist.R;
import eu.mihau.randomlist.base.BaseActivity;
import eu.mihau.randomlist.databinding.ActivityMainBinding;
import eu.mihau.randomlist.utils.list.item.CounterItem;
import eu.mihau.randomlist.utils.provider.resource.ResourceProvider;
import eu.mihau.randomlist.viewmodel.MainViewModel;
import eu.mihau.randomlist.viewmodel.ViewModelFactory;

public class MainActivity extends BaseActivity {

    @Inject
    ViewModelFactory viewModelFactory;
    @Inject
    ResourceProvider resourceProvider;

    public FastAdapter fastAdapter;
    public ItemAdapter itemAdapter;

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = viewModelFactory.get(MainViewModel.class, this);
        binding.setViewModel(viewModel);
        binding.setAdapter(fastAdapter = FastAdapter.with(Collections.singletonList(itemAdapter = new ItemAdapter())));
        for (int i = 0; i < 100; i++) {
            itemAdapter.add(new CounterItem());
        }
    }
}
