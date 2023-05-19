
package com.mycompany.assign3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class LibrarianRole implements FileNames{
    static StudentBookDatabase sBDatabase = new StudentBookDatabase(STUDENTSBOOKS_FILENAME);
    static BookDatabase booksDatabase = new BookDatabase(BOOKS_FILENAME);
    public LibrarianRole(){
    }
    public LibrarianRole(boolean flag){
        if(flag==true){
        sBDatabase.readFromFile();
        booksDatabase.readFromFile();
        }
    }
    
    public boolean addBook(String id, String title, String authorName, String publisherName, int quantity){
        Book b = new Book(id, title, authorName, publisherName, quantity);
        if(booksDatabase.contains(id)) return false;
        booksDatabase.insertRecord(booksDatabase.createRecordFrom(b.lineRepresentation()));
    return true;
    }
    
    public Book[] getListOfBooks(){
        Book[] b = (Book[]) (booksDatabase.returnAllRecords()).toArray(new Book[0]);
        return b;
    }
    public StudentBook[] getListOfBorrowingOperations(){
         StudentBook[] sb = (StudentBook[]) (sBDatabase.returnAllRecords()).toArray(new StudentBook[0]);
        return sb;
    }
    public int borrowBook(String studentId, String bookId, LocalDate borrowDate)
    {
        
        if(sBDatabase.contains(studentId+","+bookId)) return 1;
        else if((booksDatabase.getRecord(bookId)).getQuantity()==0) return 0;
        else {
            int x = booksDatabase.getRecord(bookId).getQuantity()-1;
            booksDatabase.getRecord(bookId).setQuantity(x);
            StudentBook sb = new StudentBook(studentId, bookId, borrowDate);
            sBDatabase.insertRecord(sb);
            return 2;
        } 
    }
    public double returnBook(String studentId, String bookId, LocalDate returnDate){
        int x = booksDatabase.getRecord(bookId).getQuantity()+1;
            booksDatabase.getRecord(bookId).setQuantity(x);
            double y = ChronoUnit.DAYS.between(sBDatabase.getRecord(studentId+","+bookId).getBorrowDate(),returnDate);
            sBDatabase.deleteRecord(studentId+","+bookId);
            if(y<7.0) return 0;
            return (y-7)*0.5;
            
    }
    public void logout(){
        booksDatabase.saveToFile();
        sBDatabase.saveToFile();
    }
    
    
    
    
}
