package pl.edu.pwr.ztw.books;

import java.util.Collection;

public interface IBookService {
    public abstract Collection<Book> getBooks();
    public abstract Book getBook(int id);
    public abstract void addBook(Book book);
    public abstract boolean updateBook(int id, Book book);
    public abstract boolean deleteBook(int id);
}
