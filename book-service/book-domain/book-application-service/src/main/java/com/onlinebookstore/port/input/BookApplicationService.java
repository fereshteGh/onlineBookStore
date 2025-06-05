package com.onlinebookstore.port.input;

import com.onlinebookstore.dto.command.CreateBookCommand;
import com.onlinebookstore.dto.command.UpdateBookCommand;
import com.onlinebookstore.dto.response.BookResponse;

public interface BookApplicationService {
    BookResponse createBook(CreateBookCommand createBookCommand);
    BookResponse updateBook(UpdateBookCommand updateBookCommand);
    BookResponse deleteBook(String isbn);
}
