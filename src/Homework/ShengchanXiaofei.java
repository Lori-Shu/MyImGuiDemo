package Homework;

public class ShengchanXiaofei {
    public static void main(String[] args) {
        Bint i = new Bint(1);
        Thread t1 = new Thread(new t1(i));
        Thread t2 = new Thread(new t2(i));
        t1.start();
        t2.start();
    }
}
class Bint {
    public int i;

    public Bint(int i) {
        this.i = i;
    }

    public Bint() {
    }

    @Override
    public String toString() {
        return "Bint{" +
                "i=" + i +
                '}';
    }
}
class t1 implements Runnable {
     private  Bint i;

    public t1(Bint i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (i) {
                if (i.i % 2 == 0) {
                    try {
                        i.wait();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(" t1---> " + i.i);
                i.i = i.i + 1;
                i.notify();
            }
        }
    }
}
class t2 implements Runnable {
    private Bint i;

    public t2(Bint i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (i) {
            if (i.i % 2 != 0) {
                    try {
                        i.wait();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            System.out.println(" t2---> " + i.i);
                i.i = i.i + 1;
                i.notify();
            }
        }
    }
}

