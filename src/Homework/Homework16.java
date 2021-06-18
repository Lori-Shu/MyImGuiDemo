package Homework;

public class Homework16 {
    public static void main(String[] args) {
        Laptop l1 = new Laptop("������");
        l1.i1 = new Keyboard();
        l1.i1.insert();
        l1.i1.pull();
        l1.i1 = new Emouse();
        l1.i1.insert();
        l1.i1.pull();
        l1.i1 = new Emonitor();
        l1.i1.insert();
        l1.i1.pull();
        l1.i1 = new Eprinter();
        l1.i1.insert();
        l1.i1.pull();
    }
}
class Laptop{
    private String band;
    InsertDrawable i1;

    public Laptop() {
        this(null);
    }

    public Laptop(String band) {
        this.band = band;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

}
interface InsertDrawable{
    void insert();
    void pull();
}
class Emouse implements InsertDrawable{
    public Emouse() {
    }

    public void insert(){
        System.out.println("������ӿڣ�");
    }

    @Override
    public void pull() {
        System.out.println("���γ��ӿ�!");
    }
}
class Keyboard implements InsertDrawable{
    public Keyboard() {
    }

    @Override
    public void insert() {
        System.out.println("���̲���ӿ�");
    }

    @Override
    public void pull() {
        System.out.println("���̰γ��ӿ�");
    }
}
class Emonitor implements InsertDrawable{
    public Emonitor() {
    }

    @Override
    public void insert() {
        System.out.println("��ʾ������ӿ�");
    }

    @Override
    public void pull() {
        System.out.println("��ʾ���γ��ӿ�");
    }
}
class Eprinter implements InsertDrawable{
    public Eprinter() {
    }

    @Override
    public void insert() {
        System.out.println("��ӡ������ӿ�");
    }

    @Override
    public void pull() {
        System.out.println("��ӡ���γ��ӿ�");
    }
}
