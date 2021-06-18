package Homework;

public class Homework19 {
    public static void main(String[] args) {
        Army a14 = new Army(6);
        Weapon paijipao = new PaiJiPao(1);
        Weapon paijipao2 = new PaiJiPao(2);
        Weapon hangkongmujian = new HangKongMuJiang(1);
        Weapon hongzhaji = new HongZhaJi(1);
        Weapon hangkongmujian2 = new HangKongMuJiang(2);
        Weapon hangkongmujian3 = new HangKongMuJiang(3);
        Weapon hangkongmujian4 = new HangKongMuJiang(4);
        try{
        a14.addWeapon(paijipao);

        a14.addWeapon(paijipao2);
        a14.addWeapon(hangkongmujian);
        a14.addWeapon(hongzhaji);
        a14.addWeapon(hangkongmujian2);
        a14.addWeapon(hangkongmujian3);
        a14.addWeapon(hangkongmujian4);
        }catch(WeaponException w){
            System.out.println(w.getMessage());
        }finally{
            a14.attackAll();
            a14.moveAll();
        }
    }
}
class Army{
    private int all;
    private int y = 0;
    private Weapon[] w;
    public Army(){

    }
    public Army(int a){
        all = a;
        w = new Weapon[a];
    }
    public void addWeapon(Weapon wa)throws WeaponException{
        if(y == all){
          throw   new WeaponException("武器库已满，无法继续添加武器！");
        }
        w[y] = wa;
        ++y;
    }
    public void attackAll() throws WeaponException{
        if(0 == y){
            throw new WeaponException("武器库中没有武器！无法攻击！");
        }
        for(int i=0;i<y;++i){
            w[i].attack();
        }
    }
    public void moveAll() throws WeaponException{
        if(0 == y){
            throw new WeaponException("武器库中没有武器！无法移动！");
        }
        for(int i =0;i<y;++i){
            if(true == w[i].getMovex() ){
                w[i].move();
            }
        }
    }
}
class Weapon{
    private String name;
    private Boolean movex;
    public String toString(){
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMovex() {
        return movex;
    }

    public void setMovex(Boolean movex) {
        this.movex = movex;
    }
    public void attack(){
    }
    public void move(){
    }
}
class PaiJiPao extends Weapon{
    public PaiJiPao(int i){
        setName("迫击炮"+i);
        setMovex(false);
    }
public void attack(){
    System.out.println(getName()+"正在朝敌军开炮！");
}
public void move(){
    System.out.println("迫击炮无法移动！");
}
}
class HangKongMuJiang extends Weapon{
    public HangKongMuJiang(int i){
        setName("航空母舰"+i);
        setMovex(true);
    }

    @Override
    public void attack() {
        System.out.println(getName()+"正在对敌方阵地进行立体打击！");
    }

    @Override
    public void move() {
        System.out.println(getName()+"正在敌军领海航行！");
    }
}
class HongZhaJi extends Weapon{
    public HongZhaJi(int i){
        setName("轰炸机"+i);
        setMovex(true);
    }

    @Override
    public void attack() {
        System.out.println(getName()+"正在轰炸敌方阵地！");
    }

    @Override
    public void move() {
        System.out.println(getName()+"正在敌军上空飞行！");
    }
}
class WeaponException extends RuntimeException{
    public WeaponException() throws RuntimeException{

    }
    public WeaponException(String str) throws RuntimeException{
        super(str);
    }
}
