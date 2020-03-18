package com.example.daggeradvance.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class Resource<T> {
    @NonNull
    public final AuthStatus status;

    @Nullable
    public final String message;

    @Nullable
    public final T data;


    public Resource(@NonNull AuthStatus status, @Nullable String message, @Nullable T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> Resource<T> authenticated(@Nullable T data) {
        return new Resource<>(AuthStatus.AUTHENTICATED, null, data);
    }

    public static <T> Resource<T> error(@Nullable String error, @Nullable T data) {
        return new Resource<>(AuthStatus.ERROR, error, data);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(AuthStatus.LOADING, null, data);
    }

    public static <T> Resource<T> signOut() {
        return new Resource<>(AuthStatus.NOT_AUTHENTICATED, null, null);
    }


    public enum AuthStatus {AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED}

}