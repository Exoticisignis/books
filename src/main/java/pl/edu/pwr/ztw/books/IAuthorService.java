package pl.edu.pwr.ztw.books;

import java.util.Collection;

public interface IAuthorService {
    public abstract Collection<Author> getAuthors();
    public abstract Author getAuthor(int id);
    public abstract void addAuthor(Author author);
    public abstract boolean updateAuthor(int id, Author author);
    public abstract boolean deleteAuthor(int id);
}
