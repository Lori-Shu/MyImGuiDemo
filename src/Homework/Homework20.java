package Homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Homework20 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {

            fis = new FileInputStream("F:\\Ava Max-Sweet but Psycho.flac");
            fos = new FileOutputStream("F:\\Ava Max-Sweet but Psycho2.flac");
            byte[] bytes = new byte[1024 * 1024];
            int readCount = 0;
            while ((readCount = fis.read(bytes)) != -1) {
                fos.write(bytes,0,readCount);
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (fis != null) {
                    fis.close();
                }
            }catch (IOException e) {
                    e.printStackTrace();
                }
            try {
                if (fos != null) {
                    fos.close();
                }
            }catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
}
