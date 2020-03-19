package com.example.daggeradvance.ui.auth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class AuthResource<T> {
    @NonNull
    public final AuthStatus status;

    @Nullable
    public final String message;

    @Nullable
    public final T data;


    public AuthResource(@NonNull AuthStatus status, @Nullable String message, @Nullable T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> AuthResource<T> authenticated(@Nullable T data) {
        return new AuthResource<>(AuthStatus.AUTHENTICATED, null, data);
    }

    public static <T> AuthResource<T> error(@Nullable String error, @Nullable T data) {
        return new AuthResource<>(AuthStatus.ERROR, error, data);
    }

    public static <T> AuthResource<T> loading(@Nullable T data) {
        return new AuthResource<>(AuthStatus.LOADING, null, data);
    }

    public static <T> AuthResource<T> signOut() {
        return new AuthResource<>(AuthStatus.NOT_AUTHENTICATED, null, null);
    }


    public enum AuthStatus {AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED}

}