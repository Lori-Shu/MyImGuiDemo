public class Homework3 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数");
        java.util.Scanner s = new java.util.Scanner(System.in);
        int x = s.nextInt();
        for (int i = 1; i <= x; ++i) {
            for (int k=i; k < x; ++k) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2*i-1); ++j) {
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}