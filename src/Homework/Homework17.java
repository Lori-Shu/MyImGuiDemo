package Homework;

import java.util.Random;

public class Homework17 {
    /*
    生成5个不同的不为零的随机数
     */
    public static void main(String[] args) {
        int[] i = new int[5];
        Random random = new Random();
        int x =0;
        a:for (int j = 1; j <= 5;++j ){
            int rmi = random.nextInt(101);
            for(int k = 0; k<5;++k){
                if(i[k] == rmi ){
                    --j;
                    continue a;
                }
            }
            i[x] = rmi;
            ++x;
        }
        for(int y = 0 ;y < 5;++y){
            System.out.println(i[y]);
        }
    }
}
