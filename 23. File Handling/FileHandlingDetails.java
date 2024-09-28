package FileHandling;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileHandlingDetails {

    // exists : check if file or directory exists
    // canWrite : can write or not
    // canRead : can read or not
    // getName : name of file
    // getParent : name of path
    // getAbsolutPath : get full address with file name
    // getCanonicalPath : get full address without symbols
    // isFile : file or not
    // isFolder : folder or not
    // createNewFile : create a new file
    // mkdir : make directory
    // list : list of array file in the directory
    // delete : delete file
    // length : length of the file in bytes

    public static void main(String[] args) throws IOException, InterruptedException {

        // File Class
        File file = new File("text.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File Created.");
            } else {
                System.out.println("File Already Exists.");
            }
        } catch (IOException e) {
            System.out.println("An Error Occured.");
            e.printStackTrace();            
        }
        
        // String[] str = file.list();
        // for (String string : str) {
        //     String path2 = "E:\\NearByShare\\" + string;
        //     System.out.println(new File(path2).getName());
        //     Thread.sleep(1500);
        //     // 1000 - 1 sec
        // }

        /*
        // Using try_catch can prevent from many damage :
            ~ File Not Found
            ~ Permission Issue
            ~ Disk Full
            ~ File Already in Use
            ~ Currupted File
        */
        // File Writer and File Reader Classes
        try (FileWriter write = new FileWriter("text.txt")) {
            write.write("Systumm pe Systumm bhaithariya chhora jaatt daa...!");
        } catch (IOException e) {
            System.out.println("Error Occurred.");
            e.printStackTrace();
        }
        
        try (FileReader read = new FileReader("text.txt")) {
            int ch;
            while ((ch = read.read()) != -1) {
                System.out.print((char)ch);
            }
        } catch (IOException e) {
            System.out.println("Error Occured.");
            e.printStackTrace();
        }

        // BufferWriter and BufferReader Classes
        // BufferedWriter write = new BufferedWriter(new FileWriter("text.txt")) 
        // this will overwrite the text on already exisited file but the other on will append at the end
        try (BufferedWriter write = new BufferedWriter(new FileWriter("text.txt", true))) {
            write.write("\nTere sahar me rokka bajje Rao sahab ka chhori behisab da gaddi aar para da.");
        } catch (IOException e) {
            System.out.println("Rokka nahi bajj paya...!");
            e.printStackTrace();
        }

        System.out.println();

        try (BufferedReader read = new BufferedReader(new FileReader("text.txt"))) {
            String line;
            while ((line = read.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("An Error Occurred.");
            e.printStackTrace();
        }

        // PrintWriter Class - this will overwrite the text.
        try (PrintWriter write = new PrintWriter("text.txt")) {
            write.write("Jadav Ji-Jadav Ji, Jadav Ji dudwa piyavele ne khatal me bithai ke.");
            System.out.println("Dudh nikal gya.");
        } catch (Exception e) {
            System.out.println("Dudh nahi nikla.");
            e.printStackTrace();
        }
    }
}