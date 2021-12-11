package client;

import domain.Book;
import domain.Chapter;
import domain.Publisher;
import service.BookStoreService;

import java.util.ArrayList;
import java.util.List;

public class BookstoreClient {

    public static void main(String[] args) {
        BookStoreService bookStoreService = new BookStoreService();

        // persisting object graph
        Publisher publisher = new Publisher("MANN", "Manning Publications Co.");

        Book book = new Book("976546615115", "Java Persistence with Hibernate,Second Edition", publisher);

        List<Chapter> chapters = new ArrayList<>();
        Chapter chapter1 = new Chapter("Introducing JPA and Hibernate",1);
        chapters.add(chapter1);
        Chapter chapter2 = new Chapter("Domain Models and Metadata",2);
        chapters.add(chapter2);

        book.setChapters(chapters);

        bookStoreService.persistObjectGraph(book);

        // retrieving object graph
        /*
        Book book = bookStoreService.retrieveObjectGraph("976546615115");
        System.out.println(book);
         */
    }
}
