package com.onlinebookstore.entity;

import com.onlinebookstore.Result;
import com.onlinebookstore.Validator;
import com.onlinebookstore.valueobject.BookId;

import java.util.UUID;

public class Book extends AggregateRoot<BookId> {
    private String title;
    private String author;
    private String publisher;
    private String isbn;

    public Book() {
    }

    public Result<Void> validate() {
        return Validator.of()
            .validateNotEmpty(title, "title")
            .validateNotEmpty(author, "author")
            .validateNotEmpty(publisher, "publisher")
            .validateNotEmpty(isbn, "isbn")
            .getResult();
    }

    public void initiate() {
        setId(new BookId(UUID.randomUUID()));
    }

    private Book(Builder builder) {
        super.setId(builder.bookId);
        title = builder.title;
        author = builder.author;
        publisher = builder.publisher;
        isbn = builder.isbn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public static final class Builder {
        private BookId bookId;
        private String title;
        private String author;
        private String publisher;
        private String isbn;

        private Builder() {
        }

        public Builder bookId(BookId val) {
            bookId = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder author(String val) {
            author = val;
            return this;
        }

        public Builder publisher(String val) {
            publisher = val;
            return this;
        }

        public Builder isbn(String val) {
            isbn = val;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
