package com.mycompany.assign3;
import java.io.FileWriter;
import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
public class StudentBookDatabase extends Database<StudentBook>{
    public StudentBookDatabase(String filename) {
        setFilename(filename);
    }
    @Override
    public StudentBook createRecordFrom(String line) {
        String[] StudentBookData = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate d = LocalDate.parse(StudentBookData[2],formatter);
        StudentBook b = new StudentBook(StudentBookData[0],StudentBookData[1],d);
        return b;
    }

    @Override
    public StudentBook getRecord(String key) {
        int i, flag = 1;
        StudentBook b = new StudentBook(key, key,null);
        for (i = 0; i < records.size(); i++) {
            b = records.get(i);
             if ((b.getID()+","+b.getBookID()).equals(key)) {
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
            StudentBook b = new StudentBook(null, null,null);
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
