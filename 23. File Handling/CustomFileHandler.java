package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CustomFileHandler {
    private File file;

    CustomFileHandler(String path) {
        this.file = new File(path);
    }

    boolean exists() {
        return file.exists();
    }

    boolean createNewFile() throws IOException {
        return file.createNewFile();
    }

    void write(String content) throws IOException {
        try (BufferedWriter write = new BufferedWriter(new FileWriter(file, true))) {
            write.write(content);
            write.newLine();
        }
    }

    String read() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = read.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } 

        return content.toString();
    }

    boolean delete() {
        return file.delete();
    }
}
