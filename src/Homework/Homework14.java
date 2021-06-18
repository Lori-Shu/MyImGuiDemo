package Homework;

public class Homework14 {
    public static void main(String[] args) {
          Number n = new Number(50,25);
        System.out.println(n.addition());
        System.out.println(n.subtration());
        System.out.println(n.multiplication());
        System.out.println(n.division());
    }
}
class Number{
    private int n1;
    private int n2;
    public Number(){

    }
    public Number(int n1,int n2){
        setN1(n1);
        setN2(n2);
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }
    public int addition(){
        return n1 + n2;
    }
    public int subtration(){
        return n1 - n2;
    }
    public int multiplication(){
        return  n1 * n2;
    }
    public double division(){
        return n1/n2;
    }
}
