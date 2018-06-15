package eu.mihau.randomlist.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import eu.mihau.randomlist.R;
import eu.mihau.randomlist.base.BaseActivity;
import eu.mihau.randomlist.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

}
