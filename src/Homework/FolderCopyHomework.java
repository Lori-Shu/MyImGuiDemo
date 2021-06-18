package Homework;

import java.io.*;

public class FolderCopyHomework {
    public static void main(String[] args) {
        File srcfile = new File("F:\\x");
        File destfile = new File("F:\\A\\");
        copyDir(srcfile,destfile);
    }
    public static void copyDir(File srcfile,File destfile){
        if(srcfile.isFile()) {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(srcfile);
                String path = destfile.getAbsolutePath()+"\\"+srcfile.getAbsolutePath().substring(3);
                fos = new FileOutputStream(path);
                byte[] bytes = new byte[1024 * 1024];
                int readCount ;
                while ((readCount = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, readCount);
                }
                fos.flush();
            } catch(FileNotFoundException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
            if(srcfile.isDirectory()){
            File[] files = srcfile.listFiles();
        for(File file : files){
            if(file.isDirectory()){
                String srcdir = file.getAbsolutePath();
                String destdir = destfile.getAbsolutePath()+"\\"+srcdir.substring(3);
                File newdir = new File(destdir);
                if(!newdir.exists()){
                    newdir.mkdirs();
                }
            }
            copyDir(file,destfile);
        }
    }
    }
}
