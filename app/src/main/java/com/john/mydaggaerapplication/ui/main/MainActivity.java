package com.example.daggeradvance.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.daggeradvance.BaseActivity;
import com.example.daggeradvance.R;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

}
