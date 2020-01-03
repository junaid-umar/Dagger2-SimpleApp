package com.john.mydaggaerapplication.di;

import com.john.mydaggaerapplication.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();
    @Provides
    static String someString(){
        return "This is Test String";
    }



}
