package com.onlinebookstore;

import java.util.Objects;

public class Validator<T> {
    private final T target;
    private final Notification notification;

    private Validator(T target) {
        this.target = target;
        this.notification = Notification.create();
    }

    public static <T> Validator<T> of(T target) {
        return new Validator<>(target);
    }

    public static Validator<Void> of() {
        return new Validator<>(null);
    }

    public <V> Validator<T> validate(V value,
                                     String fieldName,
                                     Specification<V> spec,
                                     String errorMessage) {
        if (!spec.isSatisfiedBy(value)) {
            notification.addError(fieldName + ": " + errorMessage);
        }
        return this;
    }

    public <V> Validator<T> validateNotNull(V value, String fieldName) {
        return validate(value, fieldName,
            Objects::nonNull, fieldName.concat(" must not be null"));
    }

    public Validator<T> validateNotEmpty(String value, String fieldName) {
        Specification<String> emptySpecification = String::isEmpty;
        Specification<String> nullSpecification = Objects::nonNull;
        return validate(value, fieldName,
            emptySpecification.and(nullSpecification),
            fieldName.concat(" must not be null or empty"));
    }

    public Result<T> getResult() {
        if (notification.hasErrors()) {
            return Result.failure(notification);
        }
        return Result.success(target);
    }
}
