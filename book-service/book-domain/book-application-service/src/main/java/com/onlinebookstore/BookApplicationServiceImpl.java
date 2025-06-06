package com.onlinebookstore;

import com.onlinebookstore.entity.Book;
import com.onlinebookstore.dto.command.CreateBookCommand;
import com.onlinebookstore.dto.command.UpdateBookCommand;
import com.onlinebookstore.dto.response.BookResponse;
import com.onlinebookstore.entity.BookDomainService;
import com.onlinebookstore.mapper.BookMapper;
import com.onlinebookstore.port.input.BookApplicationService;
import com.onlinebookstore.port.output.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookApplicationServiceImpl implements BookApplicationService {
    private final BookMapper bookMapper;
    private final BookDomainService bookDomainService;
    private final BookRepository bookRepository;

    public BookApplicationServiceImpl(BookMapper bookMapper,
                                      BookDomainService bookDomainService,
                                      BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookDomainService = bookDomainService;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse createBook(CreateBookCommand createBookCommand) {
        Book book = bookMapper.toBook(createBookCommand);
        bookDomainService.validateAndInitiate(book);
        book = bookRepository.save(book);
        return new BookResponse(book.getIsbn(), "book added");
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
