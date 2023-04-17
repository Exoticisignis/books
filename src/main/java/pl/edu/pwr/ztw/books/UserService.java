package pl.edu.pwr.ztw.books;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements IUserService{
    private static List<User> usersRepo = new ArrayList<>();
    static{
        usersRepo.add(new User(1, "Username1", "Lastname1"));
        usersRepo.add(new User(2,"Username2", "Lastname2"));
        usersRepo.add(new User(3, "Username3", "Lastname3"));
    }
    @Override
    public Collection<User> getUsers(){
        return usersRepo;
    }
    @Override
    public User getUser(int id){
        return usersRepo.stream()
                .filter(b->b.getId() == id)
                .findAny()
                .orElse(null);
    }
}
