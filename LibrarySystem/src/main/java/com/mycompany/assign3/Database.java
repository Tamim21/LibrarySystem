
package com.mycompany.assign3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


abstract public class Database<T>{
    protected ArrayList<T> records = new ArrayList<T>();
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    public void insertRecord(T record) {
        records.add(record);
    }
    public void readFromFile() {
        try {
            File file = new File(getFilename());
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(createRecordFrom(line)!=null)
                insertRecord(createRecordFrom(line));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File Not Found 404");
        }
    }

    public ArrayList<T> returnAllRecords() {
        return records;
    }
    public boolean contains(String key){
        if(getRecord(key)==null) return false;
        return true;  
    }
    
    
    public boolean deleteRecord(String key){
        if(contains(key)) {records.remove(getRecord(key));
        return true;}
        else return false;
    }
    abstract public void saveToFile();
    abstract public T getRecord(String key);
    abstract public T createRecordFrom(String line);
    
     
}
