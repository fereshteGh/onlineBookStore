package com.onlinebookstore.entity;

import com.onlinebookstore.Notification;
import com.onlinebookstore.Result;

public class BookDomainServiceImpl implements BookDomainService {
    @Override
    public void validateAndInitiate(Book book) {
        Result<Void> result = book.validate();
        if (result.isFailure()) {
            throw new RuntimeException(
                result.getNotification()
                    .map(Notification::errorMessage)
                    .orElse("Validation failed with unknown error.")
            );
        }
        book.initiate();
    }
}
