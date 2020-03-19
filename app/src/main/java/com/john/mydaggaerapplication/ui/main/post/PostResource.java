package com.example.daggeradvance.ui.main.post;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PostResource<T> {

    @Nullable
    public Status status;

    @Nullable
    public T data;


    @NonNull
    public String message;

    public PostResource(@Nullable Status status, @Nullable T data, @NonNull String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }



    public static <T> PostResource<T> loading(T data) {
        return new PostResource<>(Status.LOADING, data, null);
    }

    public static <T> PostResource<T> success(T data) {
        return new PostResource<>(Status.SUCCESS, data, null);
    }

    public static <T> PostResource<T> error(T data, String error) {
        return new PostResource<>(Status.ERROR, data, error);
    }

    public enum Status {LOADING, SUCCESS, ERROR}
}
