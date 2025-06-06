package com.onlinebookstore.mapper;

import com.onlinebookstore.dto.command.CreateBookCommand;
import com.onlinebookstore.dto.command.UpdateBookCommand;
import com.onlinebookstore.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toBook(CreateBookCommand command) {
        return Book.builder()
            .author(command.author())
            .isbn(command.isbn())
            .title(command.title())
            .publisher(command.publisher())
            .build();
    }

    public Book toBook(UpdateBookCommand command) {
        return Book.builder()
            .author(command.author())
            .isbn(command.isbn())
            .title(command.title())
            .publisher(command.publisher())
            .build();
    }
}
