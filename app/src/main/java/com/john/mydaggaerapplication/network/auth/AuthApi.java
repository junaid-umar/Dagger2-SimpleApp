package com.john.mydaggaerapplication.network.auth;

import com.john.mydaggaerapplication.models.User;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {
    @GET("users/{id}")
    Flowable<User>  getUser(
            @Path("id") int id
    );
}
