package pl.edu.pwr.ztw.books;

public class Author {
    private String FirstName;
    private String LastName;
    private int id;
    public Author(int id, String firstName, String lastName){
        this.FirstName = firstName;
        this.LastName = lastName;
        this.id = id;
    }
    public Author(){}
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
