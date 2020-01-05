package com.john.mydaggaerapplication.di;

import androidx.lifecycle.ViewModelProvider;

import com.john.mydaggaerapplication.viewmodels.ViewModelProviderFactory;

import dagger.Binds;
import dagger.BindsInstance;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {
    @Binds
    public abstract ViewModelProvider.Factory bindModelViewFactory(ViewModelProviderFactory modelProviderFactory);


}
