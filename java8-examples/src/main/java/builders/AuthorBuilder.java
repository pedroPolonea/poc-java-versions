package builders;

import com.github.javafaker.Faker;
import entity.Author;

import java.util.Random;

public class AuthorBuilder {
    private Author author;

    public AuthorBuilder(){
        author = new Author();
    }

    public static AuthorBuilder oneAuthor(){
        AuthorBuilder authorBuilder = new AuthorBuilder();
        authorBuilder.author.setId(UtilBuilder.newId());
        authorBuilder.author.setName(UtilBuilder.newName());

        return authorBuilder;
    }

    public Author getAuthor(){
        return this.author;
    }
}
