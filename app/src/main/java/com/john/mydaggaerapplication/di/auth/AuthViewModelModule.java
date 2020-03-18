package com.example.daggeradvance.di.auth;

import androidx.lifecycle.ViewModel;

import com.example.daggeradvance.di.ViewModelKey;
import com.example.daggeradvance.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    abstract ViewModel bindAuthViewModel(AuthViewModel viewModel);


}
