package Homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ReviewOutput {
    public static void main(String[] args) {
        try (PrintStream ignored = new PrintStream(new FileOutputStream("src/Homework/file.txt", true))) {
            //System.setOut(ps) ;
            System.out.println("Hello World");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
