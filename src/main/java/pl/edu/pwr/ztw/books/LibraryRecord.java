package pl.edu.pwr.ztw.books;

public class LibraryRecord {
    private int id;
    private int bookId;
    private boolean status;
    private int userId;
    public LibraryRecord(int id, int bId, boolean s, int uId){
        this.id = id;
        this.bookId = bId;
        this.status = s;
        this.userId = uId;
    }
    public LibraryRecord(int id, int bId){
        this.id = id;
        this.bookId = bId;
        this.status = true;
        this.userId = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
