package pl.edu.pwr.ztw.books;

import java.util.Collection;

public interface ILibraryService {
    public abstract boolean borrowBook(int bId, User user);
    public abstract boolean returnBook(int bId, User user);
    public abstract void addRecord(LibraryRecord record);
    public abstract boolean deleteRecord(int id);
    public abstract Collection<LibraryRecord> getRecords();
    public abstract LibraryRecord getRecord(int id);
}
