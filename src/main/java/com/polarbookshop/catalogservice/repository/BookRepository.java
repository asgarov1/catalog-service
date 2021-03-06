package com.polarbookshop.catalogservice.repository;

import com.polarbookshop.catalogservice.domain.Book;

import java.util.Collection;
import java.util.Optional;

public interface BookRepository {
    Collection<Book> findAllOrderByTitle();
    Optional<Book> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    Book save(Book book);
    Book delete(Book book);
    Book update(String isbn, Book book);
}
