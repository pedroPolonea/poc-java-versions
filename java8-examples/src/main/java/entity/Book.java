package entity;


import java.util.List;
import java.util.Optional;

public class Book {

    private Long id;

    private String title;

    private Integer numberPages;

    private List<Optional<Author>> authors;

    private List<Author> authorsList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(Integer numberPages) {
        this.numberPages = numberPages;
    }

    public List<Optional<Author>> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Optional<Author>> authors) {
        this.authors = authors;
    }

    public List<Author> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Author> authorsList) {
        this.authorsList = authorsList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numberPages=" + numberPages +
                ", authors=" + authors +
                '}';
    }

}
