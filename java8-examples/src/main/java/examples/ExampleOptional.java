package examples;

import builders.AuthorBuilder;
import builders.BookBuilder;
import entity.Author;
import entity.Book;

import java.util.Optional;

public class ExampleOptional {
    public static void main(String[] args) {
        Book book = BookBuilder.oneBook().getBook();
        Author author = AuthorBuilder.oneAuthor().getAuthor();

        exampleNullOptionsBoxFull(author);
        exampleNullOptionsBoxSmall(author);
        exampleNotNullOptionsBox(book);

        exampleNullOptionsBoxFull(null);
        exampleNullOptionsBoxSmall(null);
        System.out.println("-- Optional flat --");
        exampleNullOptionsBoxSmallToMergeOptional(book);

        System.out.println("-- Optional or Throw --");
        try {
            exampleNullOptionsBoxSmallToThrow(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-- Optional or OrElse return value default --");
        exampleNullOptionsBoxSmallToOrElse(null);

    }

    private static void exampleNotNullOptionsBox(Book book){
        Optional<Book> bookOptional = Optional.of(book);
        bookOptional.ifPresent(System.out::println);
    }

    private static void exampleNullOptionsBoxFull(Author author){
        Optional<Author> authorOptional = Optional.ofNullable(author);

        Optional<String> nameOptional = authorOptional.map(Author::getName);
        nameOptional.ifPresent(System.out::println);
    }

    private static void exampleNullOptionsBoxSmall(Author author){
        Optional<Author> authorOptional = Optional.ofNullable(author);

        authorOptional.map(Author::getName).ifPresent(System.out::println);
    }

    private static void exampleNullOptionsBoxSmallToMergeOptional(Book book){
         Optional.ofNullable(book)
                .map(Book::getAuthors)
                    .flatMap(optionals -> optionals.get(0))
                        .map(Author::getName)
                            .ifPresent(System.out::println);
    }

    private static void exampleNullOptionsBoxSmallToThrow(Book book) throws Exception {
        Optional.ofNullable(book)
                .map(Book::getAuthors)
                .flatMap(optionals -> optionals.get(0))
                .map(Author::getName)
                .orElseThrow(() -> new Exception("The object is null, please check."));
    }

    private static void exampleNullOptionsBoxSmallToOrElse(Author author) {
        Optional<Author> authorOptional = Optional.ofNullable(author);

        String name = authorOptional.map(Author::getName).orElse("N/A");
        System.out.println(name);
    }
}
