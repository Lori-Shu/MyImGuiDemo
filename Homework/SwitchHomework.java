public class SwitchHomework{
    public static void main(String[ ] args){
  System.out.print("������ɼ�");
   java.util.Scanner s=new java.util.Scanner(System.in);
    double score = s.nextDouble();
     String str;
          switch((int)score/10){
              case 0: case 1: case 2: case 3: case 4: case 5:
                  if(score>=0){str="������";
                  }else { str="������ĳɼ����Ϸ�";
                  }break;
              case 6:
                  str="����";
                  break;
              case 7:
                  str="��";
                  break;
              case 8:
                  str="��";
                  break;
              case 9: case 10:
                  if(score<=100) {
                      str = "��";
                  }else {
                      str = "������ĳɼ����Ϸ�";
                  }
                  break;
                      default:
                          str="������ĳɼ����Ϸ�";
                  }System.out.println(str);
}
}