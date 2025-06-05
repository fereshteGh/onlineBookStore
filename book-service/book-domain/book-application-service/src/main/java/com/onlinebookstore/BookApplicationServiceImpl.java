package com.onlinebookstore;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.dto.command.CreateBookCommand;
import com.onlinebookstore.dto.command.UpdateBookCommand;
import com.onlinebookstore.dto.response.BookResponse;
import com.onlinebookstore.entity.BookDomainService;
import com.onlinebookstore.mapper.BookMapper;
import com.onlinebookstore.port.input.BookApplicationService;
import org.springframework.stereotype.Service;


@Service
public class BookApplicationServiceImpl implements BookApplicationService {
    private BookMapper bookMapper;
    private BookDomainService bookDomainService;

    public BookApplicationServiceImpl(BookMapper bookMapper, BookDomainService bookDomainService) {
        this.bookMapper = bookMapper;
        this.bookDomainService = bookDomainService;
    }

    @Override
    public BookResponse createBook(CreateBookCommand createBookCommand) {
        Book bookEntity = bookMapper.toBookEntity(createBookCommand);
        bookDomainService.validateAndInitiate(bookEntity);
        return new BookResponse(bookEntity.getIsbn(),"book added");
    }

    @Override
    public BookResponse updateBook(UpdateBookCommand updateBookCommand) {
        return null;
    }

    @Override
    public BookResponse deleteBook(String isbn) {
        return null;
    }
}
