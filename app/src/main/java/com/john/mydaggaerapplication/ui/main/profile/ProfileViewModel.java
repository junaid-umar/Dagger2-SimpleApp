package com.example.daggeradvance.ui.main.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.daggeradvance.SessionManager;
import com.example.daggeradvance.models.User;
import com.example.daggeradvance.ui.auth.AuthResource;

import javax.inject.Inject;

public class ProfileViewModel extends ViewModel {
    private static final String TAG = "ProfileViewModel";

    private final SessionManager sessionManager;
    @Inject
    public ProfileViewModel(SessionManager sessionManager) {
        Log.d(TAG, "ProfileViewModel: Called");
        this.sessionManager=sessionManager;
    }

    public LiveData<AuthResource<User>> getUser(){
        return sessionManager.getCachedUser();
    }

}
