package com.example.daggeradvance.ui.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import com.example.daggeradvance.SessionManager;
import com.example.daggeradvance.models.User;
import com.example.daggeradvance.network.Resource;
import com.example.daggeradvance.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private final AuthApi authApi;
    private SessionManager sessionManager;


    @Inject
    public AuthViewModel(AuthApi authApi, SessionManager sessionManager) {
        this.authApi = authApi;
        this.sessionManager = sessionManager;
    }

    public void authenticateWithId(int userId) {
        sessionManager.authenticateWithId(getUserWithId(userId));
    }

    private LiveData<Resource<User>> getUserWithId(int userId) {

        return LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(userId)
                        .onErrorReturn(throwable -> {
                            User error = new User();
                            error.setId(-1);
                            return error;
                        })
                        .map((Function<User, Resource<User>>) user -> {
                            if (userId == -1) {
                                return Resource.error("", null);
                            } else {
                                return Resource.authenticated(user);
                            }
                        })
                        .subscribeOn(Schedulers.io()));
    }


    public LiveData<Resource<User>> observeSession() {
        return sessionManager.getCachedUser();
    }
}

