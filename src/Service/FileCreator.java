package Service;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileCreator {

    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter formatterFullDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter formatterFullDateWithTime = DateTimeFormatter.ofPattern("HH-mm-ss");
    String currentTime = formatterFullDateWithTime.format(date);
    String currentDate = formatterFullDate.format(date);
    String dateWithTime = currentDate + "_" +currentTime;
    String month = date.getMonth().toString();

    public String createFile() throws IOException {
        File file = new File(month + "/" + dateWithTime + ".txt");
        file.createNewFile();
        return file.getCanonicalPath();
    }

    public String createFolder() {
        File file = new File(month);
        file.mkdir();
        return file.getName();
    }
    
    public void writeToFile(String fileName, char[][] array) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        String tempStr = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                bw.write(String.valueOf(array[i][j]));
            }
            bw.newLine();
        }
        bw.close();
    }

    public String getDateWithTime() {
        return dateWithTime;
    }
}
