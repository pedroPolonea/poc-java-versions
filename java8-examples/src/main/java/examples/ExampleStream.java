package examples;

import builders.BookBuilder;
import entity.Author;
import entity.Book;
import vo.AuthorVO;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ExampleStream {

    public static void main(String[] args) {
        List<Book> books = BookBuilder.oneBook().getBooks();

        examplesStreamsFilterBasic(books);
        examplesStreamsFilterFind(books);
        examplesStreamsMapBasic(books);
        examplesStreamsMapToIntBasic(books);
        examplesStreamsCollectBasic(books);
        examplesStreamsFlatMapBasic(books);
        examplesStreamsPikeBasic(books);
        examplesStreamsSkipBasic(books);
        examplesStreamsSummarizingIntBasic(books);
        examplesStreamsGroupBy(books);

    }

    private static void examplesStreamsFilterBasic(List<Book> books) {
        print("examplesStreamsFilterBasic");
        books.stream().filter(book -> book.getTitle().contains("a")).forEach(System.out::println);
    }

    private static void examplesStreamsFilterFind(List<Book> books) {
        print("examplesStreamsFilterFind");

        final Optional<Book> optionalBook = books.stream().filter(book -> {
            if (book.getId() > 1 && book.getTitle().contains("a")) {
                return true;
            }
            return false;
        }).findFirst();

        System.out.println(optionalBook.get());
    }

    private static void examplesStreamsMapBasic(List<Book> books) {
        print("examplesStreamsMapBasic");
        books.stream()
                .filter(book -> !book.getAuthors().isEmpty())
                .map(Book::getAuthors)
                .forEach(System.out::println);
    }

    private static void examplesStreamsMapToIntBasic(List<Book> books) {
        print("examplesStreamsMapToIntBasic");
        int sumNumberPages = books.stream()
                .filter(book -> !book.getAuthors().isEmpty())
                .mapToInt(Book::getNumberPages)
                .sum();
        System.out.println(sumNumberPages);
    }

    private static void examplesStreamsCollectBasic(List<Book> books) {
        print("examplesStreamsCollectBasic");
        List authors = books.stream()
                .filter(book -> !book.getAuthors().isEmpty())
                .map(Book::getAuthors)
                .collect(Collectors.toList());

        authors.forEach(System.out::println);
    }

    private static void examplesStreamsFlatMapBasic(List<Book> books) {
        print("examplesStreamsFlatMapBasic");

        List authors = books.stream()
                .map(Book::getAuthors)
                .flatMap(Collection::stream)
                .map(Optional::get)
                .filter(author -> author.getName().contains("t"))
                .collect(Collectors.toList());

        authors.forEach(System.out::println);
    }

    private static void examplesStreamsPikeBasic(List<Book> books) {
        print("examplesStreamsPikeBasic");

        List<Book> booksFilter = books.stream()
                .filter(book -> book.getTitle().contains("a"))
                .peek(System.out::println)
                .collect(Collectors.toList());

        booksFilter.forEach(System.out::println);

    }

    private static void examplesStreamsSkipBasic(List<Book> books) {
        print("examplesStreamsSkipBasic");

        List<Book> booksFilter = books.stream()
                .filter(book -> book.getTitle().contains("a"))
                .skip(2)
                .collect(Collectors.toList());

        booksFilter.forEach(System.out::println);

    }

    private static void examplesStreamsSummarizingIntBasic(List<Book> books) {
        print("examplesStreamsSkipBasic");

        IntSummaryStatistics statistics = books.stream()
                .collect(Collectors.summarizingInt(value -> value.getAuthors().size()));

        System.out.println(statistics);

    }

    private static void examplesStreamsGroupBy(List<Book> books) {
        print("examplesStreamsGroupBy");

        books.forEach(book -> {
            book.getAuthorsList().forEach(author -> {
                author.setGroup(((author.getId().intValue() % 2)==0)?"A":"B");
            });
        });

        Book book = books.get(4);
        final List<AuthorVO> authorVOList = new ArrayList<>();

        book.getAuthorsList().stream().collect(groupingBy(Author::getGroup, mapping(o -> o.getName(), toList()))).forEach((s, strings) ->
              authorVOList.add(new AuthorVO(s,strings))
        );

        System.out.println(authorVOList);
    }

    private static void print(String name) {
        System.out.println();
        System.out.println("---------------> ".concat(name));
    }

}
