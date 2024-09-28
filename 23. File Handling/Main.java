package FileHandling;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileHandling file = new FileHandling("E:\\NearByShare\\FileHandling\\text.txt", "rw");
            System.out.println(file.read());
            file.clear();
            file.write("System hi system...");
            System.out.println(file.read());
            file.write(" System pe System...", "append");
            System.out.println(file.read());
            file.write("YO YO YO YO", "new line");
            System.out.println(file.read());
        } catch (IOException e) {
            System.out.println("Error");
        }

    }
}
