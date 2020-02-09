package orzech.springframework.sampleWepApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import orzech.springframework.sampleWepApp.domain.Author;
import orzech.springframework.sampleWepApp.domain.Book;
import orzech.springframework.sampleWepApp.domain.Publisher;
import orzech.springframework.sampleWepApp.repositories.AuthorRepositories;
import orzech.springframework.sampleWepApp.repositories.BookRepositories;
import orzech.springframework.sampleWepApp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {


    private final AuthorRepositories authorRepositories;  //dependency Injection
    private final BookRepositories bookRepositories;    // dependency Injection
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepositories authorRepositories, BookRepositories bookRepositories, PublisherRepository publisherRepository) {
        this.authorRepositories = authorRepositories;
        this.bookRepositories = bookRepositories;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("Some address", "New York", "Alabama", "32-901");
        publisherRepository.save(publisher);

        Author eirc = new Author("Eric", "Test");
        Book book1 = new Book("Java 6", "12345433");

        eirc.getBooks().add(book1);
        book1.getAuthors().add(eirc);

        authorRepositories.save(eirc);
        bookRepositories.save(book1);

        book1.setPublisher(publisher);
        publisher.getBooks().add(book1);

        Author hopking = new Author("Steven", "Hopking");
        Book time = new Book("Krotka Historia Czasu", "54334653");

        publisher.getBooks().add(time);
        time.setPublisher(publisher);

        authorRepositories.save(hopking);
        bookRepositories.save(time);
        publisherRepository.save(publisher);
        authorRepositories.save(eirc);
        bookRepositories.save(book1);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of book "+ bookRepositories.count());



    }
}
