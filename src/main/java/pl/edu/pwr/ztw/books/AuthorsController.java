package pl.edu.pwr.ztw.books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorsController {
    @Autowired
    IAuthorService authorService;
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value="/get/authors", method = RequestMethod.GET)
    public ResponseEntity<Object> getAuthors(){
        return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value="/get/author/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAuthor(@PathVariable("id") int id){
        return new ResponseEntity<>(authorService.getAuthor(id), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/deleteAuthor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAuthor(@PathVariable("id") int id){
        if(authorService.deleteAuthor(id)) {
            return new ResponseEntity<>("Author has been deleted", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No such author, delete failed", HttpStatus.OK);
        }
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    public ResponseEntity<Object> addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        return new ResponseEntity<>("Author has been added", HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/updateAuthor/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>  updateAuthor(@PathVariable("id") int id, @RequestBody Author author) {
        if(authorService.updateAuthor(id, author)) {
            return new ResponseEntity<>("Author has been updated", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("No such author, update failed", HttpStatus.OK);
        }
    }
}
