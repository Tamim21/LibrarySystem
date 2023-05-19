package com.mycompany.assign3;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.*;

public class StudentBook extends User{
    private String BookID;
    private LocalDate borrowDate;

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public StudentBook(String StudentID, String bookID, LocalDate borrowDate) {
        this.setID(StudentID);
        this.setBookID(bookID);
        this.setBorrowDate(borrowDate);
    }

    public String lineRepresentation() {
        int d = this.getBorrowDate().getDayOfMonth();
        int m = this.getBorrowDate().getMonthValue();
        int y = this.getBorrowDate().getYear();
        String data;
        if(d/10==0 && m/10==0) data = this.getID() + "," + this.getBookID() + ",0" +d+ "-0" +m+ "-" +y;
        else if(d/10==0 )  data = this.getID() + "," + this.getBookID() + ",0" +d+ "-" +m+ "-" +y;
        else if(m/10==0 )  data = this.getID() + "," + this.getBookID() + "," +d+ "-0" +m+ "-" +y;
        else data = this.getID() + "," + this.getBookID() + "," +d+ "-" +m+ "-" +y;
        return data;
    }


    public String getSearchKey(){
        return this.getID() + "," + this.getBookID();
    }
}
