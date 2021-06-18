package Homework;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd HH:mm:ss SSS");
        System.out.println(sdf.format(new Date()));
    }
}
