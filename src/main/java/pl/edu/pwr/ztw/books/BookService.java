package pl.edu.pwr.ztw.books;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BookService implements IBookService{
    private static List<Book> booksRepo = new ArrayList<>();
            static{
                booksRepo.add(new Book(1,"Potop", 1, 936, "Genre1"));
                booksRepo.add(new Book(2,"Wesele", 2, 150, "Genre2"));
                booksRepo.add(new Book(3,"Dziady", 3, 292, "Genre3"));
                booksRepo.add(new Book(4, "It",4,600,"Horror"));
            }
            @Override
            public Collection<Book> getBooks(){
                return booksRepo;
            }
            @Override
            public Book getBook(int id){
                return booksRepo.stream()
                        .filter(b->b.getId() == id)
                        .findAny()
                        .orElse(null);
            }
            @Override
            public void addBook(Book book){
                int id = booksRepo.size()+1;
                book.setId(id);
                booksRepo.add(book);
            }
            @Override
            public boolean updateBook(int id, Book book){
                try{
                    for (Book value : booksRepo) {
                        if (value.getId() == id) {
                            value.setAuthor(book.getAutor());
                            value.setTitle(book.getTitle());
                            value.setPages(book.getPages());
                            value.setGenre(book.getGenre());
                            return true;
                        }
                    }
                    return false;
                }catch (IndexOutOfBoundsException e){
                    return  false;
                }
            }
            @Override
            public boolean deleteBook(int id){
                try {
                    for(int i=0; i<booksRepo.size();i++){
                        if(booksRepo.get(i).getId() == id){
                            booksRepo.remove(i);
                            return true;
                        }
                    }
                    return false;
                } catch (IndexOutOfBoundsException e){
                    return false;
                }
            }
}
