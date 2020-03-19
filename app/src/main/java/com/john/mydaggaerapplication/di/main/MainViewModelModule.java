package com.example.daggeradvance.di.main;

import androidx.lifecycle.ViewModel;

import com.example.daggeradvance.di.ViewModelKey;
import com.example.daggeradvance.ui.main.post.PostViewModel;
import com.example.daggeradvance.ui.main.profile.ProfileViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel.class)
    public abstract ViewModel bindPostViewModel(PostViewModel postViewModel);

}
