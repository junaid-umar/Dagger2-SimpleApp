package com.example.daggeradvance.network.post;

import com.example.daggeradvance.models.Post;

import java.util.List;


import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface PostApi {
    @GET("/posts")
    Flowable<List<Post>> getPosts();
}
