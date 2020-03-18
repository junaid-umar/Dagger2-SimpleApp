package com.example.daggeradvance;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.daggeradvance.models.User;
import com.example.daggeradvance.network.Resource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SessionManager {
    private static final String TAG = "SessionManager";

    private MediatorLiveData<Resource<User>> cachedUser = new MediatorLiveData<>();

    @Inject
    public SessionManager() {

    }

    public void authenticateWithId(final LiveData<Resource<User>> source) {
        if (cachedUser != null) {
            cachedUser.setValue(Resource.loading(null));

            cachedUser.addSource(source, userResource -> {
                cachedUser.setValue(userResource);
                cachedUser.removeSource(source);
            });
        }
    }

    public void logOut() {
        cachedUser.setValue(Resource.signOut());
    }

    public MediatorLiveData<Resource<User>> getCachedUser() {
        return cachedUser;
    }
}
