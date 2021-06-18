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
        System.out.println("³èÎïÔÚ³Ô¶«Î÷");
    }
}
class Dog extends Pet{
    public void eat(){
        System.out.println("¹·ÔÚ³Ô¹·Á¸");
    }
}
class Cat extends Pet{
    public void eat(){
        System.out.println("Ã¨ÔÚ³ÔÃ¨Á¸");
    }
}
class YingWu extends Pet{
    public void eat(){
        System.out.println("ğĞğÄÔÚ³ÔğĞğÄ³èÎïÁ¸");
    }
}