public class Homework13{
    public static void main(String[] args){
        Master m = new Master();
        Dog d = new Dog();
        Cat c = new Cat();
        YingWu y = new YingWu();
        m.feed(y);
    }
}
class Master{
    public void feed(Pet p){
        p.eat();
}
}
class Pet{
    public void eat(){
        System.out.println("�����ڳԶ���");
    }
}
class Dog extends Pet{
    public void eat(){
        System.out.println("���ڳԹ���");
    }
}
class Cat extends Pet{
    public void eat(){
        System.out.println("è�ڳ�è��");
    }
}
class YingWu extends Pet{
    public void eat(){
        System.out.println("�����ڳ����ĳ�����");
    }
}