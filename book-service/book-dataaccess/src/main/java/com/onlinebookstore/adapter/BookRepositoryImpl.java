package com.onlinebookstore.adapter;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.entity.BookEntity;
import com.onlinebookstore.mapper.BookDataAccessMapper;
import com.onlinebookstore.port.output.BookRepository;
import com.onlinebookstore.repository.BookJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookRepositoryImpl implements BookRepository {
    private final BookJpaRepository jpaRepository;
    private final BookDataAccessMapper mapper;

    public BookRepositoryImpl(BookJpaRepository jpaRepository,
                              BookDataAccessMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return null;
    }

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = mapper.toBookEntity(book);
        bookEntity = jpaRepository.save(bookEntity);
        return mapper.toBook(bookEntity);
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(Book book) {

    }
}
