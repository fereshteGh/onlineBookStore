package com.onlinebookstore.mapper;

import com.onlinebookstore.dto.command.CreateBookCommand;
import com.onlinebookstore.dto.command.UpdateBookCommand;
import com.onlinebookstore.entity.Book;
import org.mapstruct.Mapper;


@Mapper
public interface BookMapper {
    Book toBookEntity(CreateBookCommand command);

    Book toBookEntity(UpdateBookCommand command);
}
