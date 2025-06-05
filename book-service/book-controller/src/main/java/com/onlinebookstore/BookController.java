package com.onlinebookstore;

import com.onlinebookstore.dto.command.CreateBookCommand;
import com.onlinebookstore.dto.command.UpdateBookCommand;
import com.onlinebookstore.dto.response.BookResponse;
import com.onlinebookstore.port.input.BookApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final BookApplicationService bookApplicationService;

    public BookController(BookApplicationService bookApplicationService) {
        this.bookApplicationService = bookApplicationService;
    }

    @PostMapping()
    public ResponseEntity<BookResponse> createBook(@RequestBody CreateBookCommand createBookCommand) {
        BookResponse bookResponse = bookApplicationService.createBook(createBookCommand);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(bookResponse);
    }

    @PutMapping()
    public ResponseEntity<BookResponse> updateBook(@RequestBody UpdateBookCommand updateBookCommand) {
        BookResponse bookResponse = bookApplicationService.updateBook(updateBookCommand);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(bookResponse);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<BookResponse> deleteBook(@PathVariable String isbn) {
        BookResponse bookResponse = bookApplicationService.deleteBook(isbn);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(bookResponse);
    }
}
