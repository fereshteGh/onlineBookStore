package com.onlinebookstore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Notification {
    private final List<String> errors = new ArrayList<>();

    public void addError(String message) {
        errors.add(message);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public String errorMessage() {
        return String.join("; ", errors);
    }

    public static Notification create() {
        return new Notification();
    }
}
