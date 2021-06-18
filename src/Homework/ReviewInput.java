package Homework;

import java.io.FileInputStream;
import java.io.IOException;

public class ReviewInput {
    public static void main(String[] args) {
        FileInputStream  fi=null;
        byte[] bytes = null;
        int readcount = 0;
        try {
            bytes = new byte[4];
            fi = new FileInputStream("src/Homework/file.txt");
            while((readcount = fi.read(bytes)) != -1){
                System.out.print(new String(bytes,0,readcount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
