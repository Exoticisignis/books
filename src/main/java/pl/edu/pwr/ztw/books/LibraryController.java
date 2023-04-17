package pl.edu.pwr.ztw.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibraryController {
    @Autowired
    IBookService bookService;
    @Autowired
    IUserService userService;
    @Autowired
    ILibraryService libraryService;
    @RequestMapping(value="/library", method = RequestMethod.GET)
    public ResponseEntity<Object> getRecords(){
        return new ResponseEntity<>(libraryService.getRecords(), HttpStatus.OK);
    }
    @RequestMapping(value="/library/record/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getRecord(@PathVariable("id") int id){
        return new ResponseEntity<>(libraryService.getRecord(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/library/addRecord", method = RequestMethod.POST)
    public ResponseEntity<Object> addRecord(@RequestBody LibraryRecord record){
        libraryService.addRecord(record);
        return new ResponseEntity<>("Book has been added", HttpStatus.OK);
    }
    @RequestMapping(value = "/library/record/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRecord(@PathVariable("id") int id){
        if(libraryService.deleteRecord(id)) {
            return new ResponseEntity<>("Record has been deleted", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No such record, delete failed", HttpStatus.OK);
        }
    }
    @RequestMapping(value = "library/borrowBook/{bId}/{uId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> borrowBook(@PathVariable("bId") int bId, @PathVariable("uId") int uId){
        if(libraryService.borrowBook(bId, userService.getUser(uId))){
            return new ResponseEntity<>("Book was borrowed", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Unavailable option", HttpStatus.OK);
        }
    }
    @RequestMapping(value = "library/returnBook/{bId}/{uId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> returnBook(@PathVariable("bId") int bId, @PathVariable("uId") int uId){
        if(libraryService.returnBook(bId, userService.getUser(uId))){
            return new ResponseEntity<>("Book was returned", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Unavailable option", HttpStatus.OK);
        }
    }
}
