package com.onlinebookstore.valueobject;

import com.onlinebookstore.entity.Identity;

import java.util.UUID;

public record BookId(UUID id) implements Identity {
    @Override
    public UUID value() {
        return id;
    }
}
