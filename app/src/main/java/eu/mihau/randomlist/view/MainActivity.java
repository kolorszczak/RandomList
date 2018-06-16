package eu.mihau.randomlist.view;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.Collections;

import javax.inject.Inject;

import eu.mihau.randomlist.R;
import eu.mihau.randomlist.base.BaseActivity;
import eu.mihau.randomlist.databinding.ActivityMainBinding;
import eu.mihau.randomlist.utils.list.item.CounterItem;
import eu.mihau.randomlist.utils.provider.scheduler.SchedulerProvider;
import eu.mihau.randomlist.viewmodel.MainViewModel;
import eu.mihau.randomlist.viewmodel.ViewModelFactory;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    ViewModelFactory viewModelFactory;
    @Inject
    SchedulerProvider schedulerProvider;

    public FastAdapter fastAdapter;
    public ItemAdapter<CounterItem> itemAdapter;

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        viewModel = viewModelFactory.get(MainViewModel.class, this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
        binding.setAdapter(fastAdapter = FastAdapter.with(Collections.singletonList(itemAdapter = new ItemAdapter<>())));

        viewModel.randomEventPublishSubject
                .subscribe(randomEvent -> {
                    switch (randomEvent.type) {
                        case CREATE:
                            itemAdapter.add(new CounterItem(randomEvent.element));
                            break;
                        case UPDATE:
                            fastAdapter.notifyAdapterItemChanged(randomEvent.index);
                            break;
                        case DELETE:
                            itemAdapter.remove(randomEvent.index);
                            break;
                        case CLEAR:
                            itemAdapter.clear();
                            break;
                    }
                }, throwable -> Log.e(TAG, "randomEventPublishSubjectHandle", throwable));
    }
}
