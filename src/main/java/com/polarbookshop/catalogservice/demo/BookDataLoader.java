package com.polarbookshop.catalogservice.demo;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.persistence.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "polar.testdata.enabled", havingValue = "true")
public class BookDataLoader {

    private final BookRepository bookRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 = Book.build("1234567891", "Northern Lights", "Lyra Silvertongue", 9.90);
        var book2 = Book.build("1234567892", "Polar Journey", "Iorek Polarson", 12.90);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}

