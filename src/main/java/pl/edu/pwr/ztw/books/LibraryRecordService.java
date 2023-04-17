package pl.edu.pwr.ztw.books;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class LibraryRecordService implements ILibraryService{
    private static List<LibraryRecord> recordsRepo = new ArrayList<>();
    static{
        recordsRepo.add(new LibraryRecord(1,1));
        recordsRepo.add(new LibraryRecord(2,2));
        recordsRepo.add(new LibraryRecord(3,3));
    }
    @Override
    public boolean borrowBook(int bId, User user){
        for (LibraryRecord record : recordsRepo) {
            if (record.getBookId() == bId) {
                if (record.isStatus()) {
                    if (user.getBooksCount() < 2) {
                        record.setStatus(false);
                        record.setUserId(user.getId());
                        user.increaseBooksCount();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public boolean returnBook(int bId, User user){
        for (LibraryRecord record : recordsRepo) {
            if (record.getBookId() == bId) {
                if (record.getUserId() == user.getId()) {
                    record.setStatus(true);
                    record.setUserId(-1);
                    user.decreaseBooksCount();
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public Collection<LibraryRecord> getRecords(){
        return recordsRepo;
    }
    @Override
    public LibraryRecord getRecord(int id){
        return recordsRepo.stream()
                .filter(b->b.getId() == id)
                .findAny()
                .orElse(null);
    }
    @Override
    public void addRecord(LibraryRecord record){
        recordsRepo.add(record);
    }
    @Override
    public boolean deleteRecord(int id){
        try {
            for(int i=0; i<recordsRepo.size();i++){
                if(recordsRepo.get(i).getId() == id){
                    recordsRepo.remove(i);
                    return true;
                }
            }
            return false;
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }
}
