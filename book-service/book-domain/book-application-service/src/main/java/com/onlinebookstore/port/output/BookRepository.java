package com.onlinebookstore.port.output;

import com.onlinebookstore.entity.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    Book findByIsbn(String isbn);

    Book save(Book book);

    Book update(Book book);

    void delete(Book book);

}
