package com.john.mydaggaerapplication.di.auth;

import androidx.lifecycle.ViewModel;

import com.john.mydaggaerapplication.di.ViewModelKey;
import com.john.mydaggaerapplication.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    public abstract ViewModel binAuthViewModel(AuthViewModel authViewModel);
}
