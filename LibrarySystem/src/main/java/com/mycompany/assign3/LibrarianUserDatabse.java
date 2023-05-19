package com.mycompany.assign3;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class LibrarianUserDatabse extends Database<LibrarianUser> {
    public LibrarianUserDatabse(String filename) {
        setFilename(filename);
    }

    @Override
    public LibrarianUser createRecordFrom(String line){
        String[] LibrarianData = line.split(",");
        if(records.contains(LibrarianData[0])) return null;
        LibrarianUser b = new LibrarianUser(LibrarianData[0], LibrarianData[1], LibrarianData[2], LibrarianData[3], LibrarianData[4]);
        return b;
    }  
    
    @Override
    public LibrarianUser getRecord(String key) {
        int i, flag = 1;
        LibrarianUser b = new LibrarianUser(key, key, key, key, key);
        for (i = 0; i < records.size(); i++) {
            b = records.get(i);
            if (b.getID().equals(key)) {
                flag = 0;
                break;
            }
        }
        if (flag == 0) {
            return records.get(i);
        }
        return null;
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(getFilename());
            LibrarianUser b = new LibrarianUser(null, null, null, null, null);
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
