package com.onlinebookstore.mapper;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.entity.BookEntity;
import com.onlinebookstore.valueobject.BookId;
import org.springframework.stereotype.Component;

@Component
public class BookDataAccessMapper {
    public BookEntity toBookEntity(Book book) {
        return BookEntity.builder()
            .id(book.getId().value())
            .isbn(book.getIsbn())
            .title(book.getTitle())
            .author(book.getAuthor())
            .publisher(book.getPublisher())
            .build();
    }

    public Book toBook(BookEntity bookEntity) {
        return Book.builder()
            .bookId(new BookId(bookEntity.getId()))
            .author(bookEntity.getAuthor())
            .isbn(bookEntity.getIsbn())
            .title(bookEntity.getTitle())
            .publisher(bookEntity.getPublisher())
            .build();
    }
}
