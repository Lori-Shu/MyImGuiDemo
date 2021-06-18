public class IfHomework {
    public static void main(String[] args) {
        System.out.print("请输入成绩");
        java.util.Scanner s = new java.util.Scanner(System.in);
        double score = s.nextDouble();
        String str;
        if (score < 0 || score > 100) {
            str="输入的成绩不合法";
        } else if (score < 60) {
            str = "不及格";
        } else if (score < 70) {
            str = "及格";
        } else if (score < 80) {
            str = "中";
        } else if (score < 90) {
            str = "良";
        } else {
            str = "优";
        }
        System.out.println(str);
    }
}