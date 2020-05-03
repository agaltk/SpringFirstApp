package com.first.spring.bootstrap;

import com.first.spring.domain.Author;
import com.first.spring.domain.Book;
import com.first.spring.domain.Publisher;
import com.first.spring.repositories.AuthorRepository;
import com.first.spring.repositories.BookRepository;
import com.first.spring.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Author rod = new Author("Rod", "Johnson");

        Book ddd = new Book( "Developing Driven Domain",  "123123");
        Book noEJB = new Book( "J2EE Development without EJB",  "423423");

        Publisher john = new Publisher("John", "Scary 2", "New York", "Big and nice", "34-098");
        publisherRepository.save(john);


        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(john);
        john.getBooks().add(ddd);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(john);
        john.getBooks().add(noEJB);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(john);

    System.out.println("Start in BootStrap");
    System.out.println("Number of books " + bookRepository.count());
    System.out.println("Number of publisher books " + john.getBooks().size());
    }
}
