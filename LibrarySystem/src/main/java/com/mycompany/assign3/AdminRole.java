
package com.mycompany.assign3;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class AdminRole implements FileNames{
    static private LibrarianUserDatabse database = new LibrarianUserDatabse(LIBRARIANS_FILENAME);
    public AdminRole(){
  }
    public AdminRole(boolean flag){
        if(flag==true)
      database.readFromFile();
  }
    public boolean addLibrarian(String librarianId, String name, String email,String address, String phoneNumber)
    {
        LibrarianUser lb = new LibrarianUser(librarianId, name, email, address, phoneNumber);
        if(database.contains(librarianId)) return false;
        database.insertRecord(database.createRecordFrom(lb.lineRepresentation()));
        return true;
    }
    public LibrarianUser[] getListOfLibrarians(){
        LibrarianUser[] lb = (LibrarianUser[]) (database.returnAllRecords()).toArray(new LibrarianUser[0]);
        return lb;
    }
    public boolean removeLibrarian(String key){
        return database.deleteRecord(key);
    }
    public void logout(){
        database.saveToFile();
    }
    
}
