package com.john.mydaggaerapplication.di;

import com.john.mydaggaerapplication.di.auth.AuthModule;
import com.john.mydaggaerapplication.di.auth.AuthViewModelModule;
import com.john.mydaggaerapplication.ui.auth.AuthActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
            modules = {AuthViewModelModule.class, AuthModule.class}
    )
    abstract AuthActivity contributeAuthActivity();



}
