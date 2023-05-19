package com.mycompany.assign3;

import java.io.FileNotFoundException;
import java.io.FileWriter;

public class BookDatabase extends Database<Book>{
    
    public BookDatabase(String filename) {
        setFilename(filename);
    }
    @Override
    public Book createRecordFrom(String line) {
        String[] BookData = line.split(",");
        Book b = new Book(BookData[0], BookData[1], BookData[2], BookData[3], Integer.parseInt(BookData[4]));
        return b;
    }
    @Override
    public Book getRecord(String key) {
        int i, flag = 1;
        Book b = new Book(key, key,key,key,0);
        for (i = 0; i < records.size(); i++) {
            b = records.get(i);
            if ((b.getID()).equals(key)) {
                flag = 0;
                break;
            }
        }
        if (flag == 0) {
            return records.get(i);
        }
        return null;
    }
    @Override
    public void saveToFile() { 
        try {
            FileWriter writer = new FileWriter(getFilename());
            Book b = new Book(null, null,null,null,0);
            for (int i = 0; i < records.size(); i++) {
                b = records.get(i);
                writer.write(b.lineRepresentation());
                if ((i - 1) != records.size()) {
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
        
}
