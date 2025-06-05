package com.onlinebookstore.dto.command;

public record CreateBookCommand(String title,
                                String author,
                                String publisher,
                                String isbn) {
}
