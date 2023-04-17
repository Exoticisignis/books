package pl.edu.pwr.ztw.books;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AuthorService implements IAuthorService{
    private static List<Author> authorsRepo = new ArrayList<>();
    static{
        authorsRepo.add(new Author(1, "Henryk", " Sienkiewicz"));
        authorsRepo.add(new Author(2,"Stanisław", "Reymont"));
        authorsRepo.add(new Author(3, "Adam", "Mickiewicz"));
        authorsRepo.add(new Author(4,"Stephen", "King"));
    }
    @Override
    public Collection<Author> getAuthors(){
        return authorsRepo;
    }
    @Override
    public Author getAuthor(int id){
        return authorsRepo.stream()
                .filter(b->b.getId() == id)
                .findAny()
                .orElse(null);
    }
    @Override
    public void addAuthor(Author author){
        int id = authorsRepo.size()+1;
        author.setId(id);
        authorsRepo.add(author);
    }
    @Override
    public boolean updateAuthor(int id, Author author){
        try{
            for (Author value : authorsRepo) {
                if (value.getId() == id) {
                    value.setFirstName(author.getFirstName());
                    value.setLastName(author.getLastName());
                    return true;
                }
            }
            return false;
        }catch (IndexOutOfBoundsException e){
            return false;
        }

    }
    @Override
    public boolean deleteAuthor(int id){
        try{
            for(int i=0; i<authorsRepo.size();i++){
                if(authorsRepo.get(i).getId() == id){
                    authorsRepo.remove(i);
                    return true;
                }
            }
            return false;
        }catch (IndexOutOfBoundsException e){
            return false;
        }

    }
}
