package com.onlinebookstore.dto.command;

public record UpdateBookCommand(String title,
                                String author,
                                String publisher,
                                String isbn) {
}
