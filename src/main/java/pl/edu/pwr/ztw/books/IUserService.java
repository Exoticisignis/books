package pl.edu.pwr.ztw.books;

import java.util.Collection;

public interface IUserService {
    public abstract Collection<User> getUsers();
    public abstract User getUser(int id);
}
