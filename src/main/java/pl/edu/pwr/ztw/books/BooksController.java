package pl.edu.pwr.ztw.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksController {
    @Autowired
    IBookService bookService;
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value="/get/books", method = RequestMethod.GET)
    public ResponseEntity<Object> getBooks(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }
    @RequestMapping(value="/get/book/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBook(@PathVariable("id") int id){
        return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBook(@PathVariable("id") int id){
        if(bookService.deleteBook(id)) {
            return new ResponseEntity<>("Book has been deleted", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No such book, delete failed", HttpStatus.OK);
        }
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ResponseEntity<Object> addBook(@RequestBody Book book){
        bookService.addBook(book);
        return new ResponseEntity<>("Book has been added", HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/updateBook/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object>  updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        if(bookService.updateBook(id, book)) {
            return new ResponseEntity<>("Book has been updated", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No such book, update failed", HttpStatus.OK);
        }
    }
}
