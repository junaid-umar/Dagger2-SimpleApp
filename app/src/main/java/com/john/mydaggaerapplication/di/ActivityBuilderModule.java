package com.example.daggeradvance.di;

import com.example.daggeradvance.di.auth.AuthModule;
import com.example.daggeradvance.di.auth.AuthScope;
import com.example.daggeradvance.di.auth.AuthViewModelModule;
import com.example.daggeradvance.di.main.MainFragmentBuilderModule;
import com.example.daggeradvance.di.main.MainScope;
import com.example.daggeradvance.di.main.MainViewModelModule;
import com.example.daggeradvance.di.main.PostModule;
import com.example.daggeradvance.ui.auth.AuthActivity;
import com.example.daggeradvance.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @AuthScope
    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity contributeAuthActivity();

    @MainScope
    @ContributesAndroidInjector(
            modules = {
                    MainFragmentBuilderModule.class,
                    MainViewModelModule.class,
                    PostModule.class
            }
    )
    abstract MainActivity contributeMainActivity();

}
