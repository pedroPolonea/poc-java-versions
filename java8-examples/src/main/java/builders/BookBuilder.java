package builders;

import entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookBuilder {
    private Book book;

    public BookBuilder(){
        book = new Book();
    }

    public static BookBuilder oneBook(){
        BookBuilder builder = new BookBuilder();
        builder.book.setId(UtilBuilder.newId());
        builder.book.setTitle(UtilBuilder.newTitle());
        builder.book.setNumberPages(UtilBuilder.newNumberPages());
        builder.book.setAuthors(new ArrayList<>());
        builder.book.setAuthorsList(new ArrayList<>());
        return builder;
    }

    public void addAuthor(){
        this.book.getAuthors().add(Optional.ofNullable(AuthorBuilder.oneAuthor().getAuthor()));
    }

    public void addAuthorList(){
        this.book.getAuthorsList().add(AuthorBuilder.oneAuthor().getAuthor());
    }

    public Book getBook(){
        addAuthor();
        addAuthorList();
        return this.book;
    }

    public Book getBook(int n){
        for (int i = 1; i<=n;i++) {
            addAuthor();
            addAuthorList();
        }
        return this.book;
    }

    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();

        books.add(oneBook().getBook());
        books.add(oneBook().getBook(2));
        books.add(oneBook().getBook(4));
        books.add(oneBook().getBook());
        books.add(oneBook().getBook(5));

        return books;
    }
}
