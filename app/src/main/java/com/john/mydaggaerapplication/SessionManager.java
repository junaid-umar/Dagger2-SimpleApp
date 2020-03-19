package com.example.daggeradvance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.daggeradvance.models.User;
import com.example.daggeradvance.ui.auth.AuthResource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionManager {
    private static final String TAG = "SessionManager";

    private MediatorLiveData<AuthResource<User>> cachedUser = new MediatorLiveData<>();

    @Inject
    public SessionManager() {

    }

    public void authenticateWithId(final LiveData<AuthResource<User>> source) {
        if (cachedUser != null) {
            cachedUser.setValue(AuthResource.loading(null));

            cachedUser.addSource(source, userResource -> {
                cachedUser.setValue(userResource);
                cachedUser.removeSource(source);
            });
        }
    }

    public void logOut() {
        cachedUser.setValue(AuthResource.signOut());
    }

    public MediatorLiveData<AuthResource<User>> getCachedUser() {
        return cachedUser;
    }
}
