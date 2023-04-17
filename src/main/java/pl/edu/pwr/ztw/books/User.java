package pl.edu.pwr.ztw.books;

public class User {
    private String FirstName;
    private String LastName;
    private int id;
    private int booksCount;
    public User(int id, String firstName, String lastName){
        this.FirstName = firstName;
        this.LastName = lastName;
        this.id = id;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public void increaseBooksCount(){
        this.booksCount++;
    }
    public void decreaseBooksCount(){
        if (this.booksCount>=1){
            this.booksCount--;
        }
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
    @Override
    public String toString(){
        return this.FirstName+" "+this.LastName;
    }
}
