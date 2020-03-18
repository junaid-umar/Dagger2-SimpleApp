package com.example.daggeradvance.network.auth;

import com.example.daggeradvance.models.User;
import com.example.daggeradvance.network.Resource;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );
}
