package com.example.daggeradvance;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.daggeradvance.ui.auth.AuthActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {

    @Inject
    public SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeObserver();
    }

    private void subscribeObserver() {

        sessionManager.getCachedUser().observe(this, userResource -> {
            switch (userResource.status) {

                case LOADING:

                    break;

                case AUTHENTICATED:

                    break;
                case ERROR:

                    break;

                case NOT_AUTHENTICATED:
                    showLoginScreen();
                    break;
            }
        });
    }

    private void showLoginScreen() {
        startActivity(new Intent(BaseActivity.this, AuthActivity.class));
    }

}
