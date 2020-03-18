package com.example.daggeradvance.ui.auth;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.RequestManager;
import com.example.daggeradvance.R;
import com.example.daggeradvance.ui.main.MainActivity;
import com.example.daggeradvance.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity implements View.OnClickListener {
    private static final String TAG = "AuthActivity";

    private AuthViewModel authViewModel;
    private EditText userId;
    private ProgressBar progressBar;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Inject
    Drawable logo;

    @Inject
    RequestManager requestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        userId = findViewById(R.id.user_id_input);
        findViewById(R.id.login_button).setOnClickListener(this);
        authViewModel = new ViewModelProvider(this, providerFactory).get(AuthViewModel.class);

        progressBar = findViewById(R.id.progress_bar);
        subscribeObserver();
        setLogo();
    }

    private void subscribeObserver() {
        authViewModel.observeSession().observe(this, userResource -> {

            if (userResource != null) {
                switch (userResource.status) {
                    case LOADING: {
                        showProgressBar(true);
                        break;
                    }
                    case AUTHENTICATED: {
                        Log.d(TAG, "subscribeObserver: " + userResource.data.getEmail());
                        showProgressBar(false);
                        onLoginSuccess();
                        break;
                    }

                    case ERROR: {
                        showProgressBar(false);
                        break;
                    }
                    case NOT_AUTHENTICATED: {
                        showProgressBar(false);

                        break;
                    }
                }
            }
        });
    }

    private void onLoginSuccess() {
        startActivity(new Intent(AuthActivity.this, MainActivity.class));
    }

    private void showProgressBar(boolean isVisible) {
        progressBar.setVisibility(isVisible ? View.VISIBLE : View.INVISIBLE);
    }

    private void setLogo() {
        requestManager.load(logo)
                .into((ImageView) findViewById(R.id.login_logo));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:

                loginUser();
                break;
        }
    }

    private void loginUser() {
        if (TextUtils.isEmpty(userId.getText().toString())) {
            return;
        }
        authViewModel.authenticateWithId(Integer.parseInt(userId.getText().toString()));
    }
}
