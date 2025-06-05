package com.onlinebookstore;

import java.util.Optional;

public class Result<T> {
    private final T value;
    private final Notification notification;
    private final boolean isSuccess;

    private Result(T value, Notification notification, boolean isSuccess) {
        this.value = value;
        this.notification = notification;
        this.isSuccess = isSuccess;
    }

    public static <T> Result<T> success(T value) {
        return new Result<>(value, null, true);
    }

    public static <T> Result<T> failure(Notification notification) {
        return new Result<>(null, notification, false);
    }

    public static  Result<Void> voidResult(Notification notification) {
        return new Result<>(null, notification, true);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isFailure() {
        return !isSuccess;
    }

    public Optional<T> getValue() {
        return Optional.ofNullable(value);
    }

    public Optional<Notification> getNotification() {
        return Optional.ofNullable(notification);
    }
}
