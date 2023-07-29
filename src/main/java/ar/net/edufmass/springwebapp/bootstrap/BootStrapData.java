package ar.net.edufmass.springwebapp.bootstrap;

import ar.net.edufmass.springwebapp.domain.Author;
import ar.net.edufmass.springwebapp.domain.Book;
import ar.net.edufmass.springwebapp.domain.Publisher;
import ar.net.edufmass.springwebapp.repositories.AuthorRepository;
import ar.net.edufmass.springwebapp.repositories.BookRepository;
import ar.net.edufmass.springwebapp.repositories.PublisherRepository;
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

        System.out.println("Started in BootStrap");

        Publisher publisher = new Publisher();
        publisher.setName("Computer Publishing");
        publisher.setCity("Comodoro");
        publisher.setState("CH");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author doe = new Author("John", "Doe");
        Book ddd = new Book("Domain Driven Design", "123123");
        doe.getBooks().add(ddd);
        ddd.getAuthors().add(doe);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(doe);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author dos = new Author("John", "Dos");
        Book jsb = new Book("Java Spring Boot", "567567");
        dos.getBooks().add(jsb);
        jsb.getAuthors().add(dos);

        jsb.setPublisher(publisher);
        publisher.getBooks().add(jsb);

        authorRepository.save(dos);
        bookRepository.save(jsb);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher number of books: " + publisher.getBooks().size());
    }
}
