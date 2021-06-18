public class SwitchHomework{
    public static void main(String[ ] args){
  System.out.print("请输入成绩");
   java.util.Scanner s=new java.util.Scanner(System.in);
    double score = s.nextDouble();
     String str;
          switch((int)score/10){
              case 0: case 1: case 2: case 3: case 4: case 5:
                  if(score>=0){str="不及格";
                  }else { str="您输入的成绩不合法";
                  }break;
              case 6:
                  str="及格";
                  break;
              case 7:
                  str="中";
                  break;
              case 8:
                  str="良";
                  break;
              case 9: case 10:
                  if(score<=100) {
                      str = "优";
                  }else {
                      str = "您输入的成绩不合法";
                  }
                  break;
                      default:
                          str="您输入的成绩不合法";
                  }System.out.println(str);
}
}