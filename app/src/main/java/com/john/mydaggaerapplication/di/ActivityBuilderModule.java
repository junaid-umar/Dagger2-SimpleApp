package com.example.daggeradvance.di;

import com.example.daggeradvance.di.auth.AuthModule;
import com.example.daggeradvance.di.auth.AuthViewModelModule;
import com.example.daggeradvance.ui.auth.AuthActivity;
import com.example.daggeradvance.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
            modules = {
                    AuthViewModelModule.class,
                    AuthModule.class
            }
    )
    abstract AuthActivity contributeAuthActivity();

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

}
