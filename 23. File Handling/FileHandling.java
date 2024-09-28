package FileHandling;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileHandling {

    private RandomAccessFile file;
    private String filePath;
    private String mode;

    // Constructor 
    FileHandling(String path, String mode) throws IOException {
        this.filePath = path;
        this.mode = mode;
        this.open();
    }

    // Opening a File
    void open() throws IOException {
        this.file = new RandomAccessFile(filePath, mode);
    }

    // Reading a File
    String read() throws IOException {
        if (file == null) throw new IOException("File not found.");
        
        StringBuilder lines = new StringBuilder();
        String line;
        file.seek(0);

        while ((line = file.readLine()) != null) {
            lines.append(line);
            lines.append("\n");
        }

        return lines.toString();
    }

    // Writing a File
    void write(String data) throws IOException {
        if (file == null) throw new IOException("File not found.");
        clear();
        file.writeBytes(data);
    }
    
    // Writing a File with choice
    void write(String data, String need) throws IOException {
        if (file == null) throw new IOException("File not found");

        switch (need) {
            case "append":
                append(data);
                break;
            case "new line":
                appendNewLine(data);
                break;
            default:
                System.out.println("wrong input need.");
        }
    }

    // Appending in File
    private void append(String data) throws IOException {
        if (file == null) throw new IOException("File not found.");
        file.writeBytes(data);
    }

    // Appending from New Line
    private void appendNewLine(String data) throws IOException {
        if (file == null) throw new IOException("File not found.");

        file.write('\n');
        file.writeBytes(data);
    }

    // Closing a File
    void close() throws IOException {
        if (file != null) {
            file.close();
            file = null;
        }
    }

    // Clearing the File
    void clear() throws IOException {
        if (file == null) throw new IOException("File not found.");
        file.setLength(0);;
    }
}
