package com.john.mydaggaerapplication.di;

import android.app.Application;


import com.john.mydaggaerapplication.BaseApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component (modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class,
})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

}
