public class IfHomework {
    public static void main(String[] args) {
        System.out.print("������ɼ�");
        java.util.Scanner s = new java.util.Scanner(System.in);
        double score = s.nextDouble();
        String str;
        if (score < 0 || score > 100) {
            str="����ĳɼ����Ϸ�";
        } else if (score < 60) {
            str = "������";
        } else if (score < 70) {
            str = "����";
        } else if (score < 80) {
            str = "��";
        } else if (score < 90) {
            str = "��";
        } else {
            str = "��";
        }
        System.out.println(str);
    }
}