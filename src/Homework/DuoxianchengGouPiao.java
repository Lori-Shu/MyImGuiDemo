package Homework;

public class DuoxianchengGouPiao {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        BuyThread b1 = new BuyThread(t);
        BuyThread b2 = new BuyThread(t);
        BuyThread b3 = new BuyThread(t);
        BuyThread b4 = new BuyThread(t);
        BuyThread b5 = new BuyThread(t);
        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b2);
        Thread t3 = new Thread(b3);
        Thread t4 = new Thread(b4);
        Thread t5 = new Thread(b5);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.see();


    }
}
class BuyThread implements Runnable{
    private Ticket t;
    public BuyThread(Ticket x) {
        t = x;

    }

    @Override
    public void run() {
        t.buy();
    }
}
class Ticket{
    private  int sum = 100;

    public Ticket() {
    }
    public synchronized void buy(){
        int s = this.getSum();
        if(s == 0){
            System.out.println(" 票已售光！ ");
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setSum(s - 1);
        System.out.println(" 票售出一张！ ");
    }
    public void see(){
        System.out.println(" 剩余的票数： " + sum);
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
