package pl.edu.pwr.ztw.books;

public class Book {
    private int id;
    private String title;
    private int author;
    int pages;
    private String genre;
    public Book(){}
    public Book(int id, String title, int author, int pages){
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }
    public Book(int id, String title, int author, int pages, String genre){
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.genre = genre;
    }
    public Book(String title, int author, int pages, String genre){
        this.id = 0;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public int getAutor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(Author author){ this.author = author.getId();}

    public void setAuthor(int author){ this.author = author;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString(){
        return this.title+this.genre;
    }
}
