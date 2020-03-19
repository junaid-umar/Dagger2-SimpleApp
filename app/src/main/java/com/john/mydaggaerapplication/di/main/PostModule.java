package com.example.daggeradvance.di.main;

import com.example.daggeradvance.network.post.PostApi;
import com.example.daggeradvance.ui.main.post.PostsRecyclerAdapter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class PostModule {

    @MainScope
    @Provides
    static PostApi providePostApi(Retrofit retrofit) {
        return retrofit.create(PostApi.class);
    }

    @MainScope
    @Provides
    static PostsRecyclerAdapter provideRecyclerAdapter() {
        return new PostsRecyclerAdapter();
    }

}
