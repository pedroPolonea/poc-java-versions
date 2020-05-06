package examples;

import builders.BookBuilder;
import entity.Book;

import java.util.List;

public class ExampleForEach {

    public static void main(String[] args) {

        List<Book> books = BookBuilder.oneBook().getBooks();

        forEachSyntaxFull(books);
        forEachSyntaxSmall(books);

    }

    private static void forEachSyntaxFull(List<Book> books){
        System.out.println("------");
        System.out.println("forEachSyntaxFull");
        books.forEach((Book b) -> {
            System.out.println(b);
        });
    }

    private static void forEachSyntaxSmall(List<Book> books){
        System.out.println("------");
        System.out.println("forEachSyntaxSmall");
        books.forEach(b -> System.out.println(b));
    }
}
