package Homework;

public class Homework15 {
    public static void main(String[] args) {
         SalariedEmployee e1 = new SalariedEmployee("张三",12,5000);
         e1.defaultSalary();
         HourlyEmployee e2 = new HourlyEmployee("李四",5,50,166);
         e2.defaultSalary();
         SalesEmployee e3 = new SalesEmployee("王二",4,10000,0.36);
         e3.defaultSalary();
         BasePlusSalesEmployee e4 = new BasePlusSalesEmployee("麻子",4,10000,0.36,1000);
         e4.defaultSalary();
        System.out.println("你好世界！");
    }
}
class Employee{
    private String name;
    private int birthMonth;
    private double salary;
    static int month=4;
    public void getAllSalary(){
        if(birthMonth == month){
            setSalary(getSalary()+100);
        }else{
            return;
        }
    }

    public Employee() {
    }

    public Employee(String name, int birthMonth) {
        this.name = name;
        this.birthMonth = birthMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
class SalariedEmployee extends Employee{
    private int monthSalary;
    public SalariedEmployee(){
    }

    public SalariedEmployee(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    public SalariedEmployee(String name, int birthMonth, int monthSalary) {
        super(name, birthMonth);
        this.monthSalary = monthSalary;
    }

    public int getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(int monthSalary) {
        this.monthSalary = monthSalary;
    }
    public void defaultSalary() {
        setSalary(monthSalary);
        getAllSalary();
        System.out.println(getSalary());
    }
}
class HourlyEmployee extends Employee{
    private int hourSalary;
    private int workHour;
    public HourlyEmployee(){
    }
    public HourlyEmployee(int hourSalary, int workHour) {
        this.hourSalary = hourSalary;
        this.workHour = workHour;
    }

    public HourlyEmployee(String name, int birthMonth, int hourSalary, int workHour) {
        super(name, birthMonth);
        this.hourSalary = hourSalary;
        this.workHour = workHour;
    }

    public int getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(int hourSalary) {
        this.hourSalary = hourSalary;
    }

    public int getWorkHour() {
        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public void defaultSalary() {
        if (workHour > 160) {
              setSalary(hourSalary * 160 + (workHour-160) * 1.5 * hourSalary);
              getAllSalary();
            System.out.println(getSalary());
        }
    }
}
class SalesEmployee extends Employee{
    private int monthSalesVolume;
    private double commissionRate;

    public SalesEmployee() {
    }

    public SalesEmployee(int monthSalesVolume, double commissionRate) {
        this.monthSalesVolume = monthSalesVolume;
        this.commissionRate = commissionRate;
    }

    public SalesEmployee(String name, int birthMonth, int monthSalesVolume, double commissionRate) {
        super(name, birthMonth);
        this.monthSalesVolume = monthSalesVolume;
        this.commissionRate = commissionRate;
    }

    public int getMonthSalesVolume() {
        return monthSalesVolume;
    }

    public void setMonthSalesVolume(int monthSalesVolume) {
        this.monthSalesVolume = monthSalesVolume;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
     public  void defaultSalary(){
        setSalary(monthSalesVolume * commissionRate);
        getAllSalary();
         System.out.println(getSalary());
    }
}
class BasePlusSalesEmployee extends SalesEmployee{
    private int leastSalary;

    public BasePlusSalesEmployee() {
    }

    public BasePlusSalesEmployee(int leastSalary) {
        this.leastSalary = leastSalary;
    }

    public BasePlusSalesEmployee(int monthSalesVolume, double commissionRate, int leastSalary) {
        super(monthSalesVolume, commissionRate);
        this.leastSalary = leastSalary;
    }

    public BasePlusSalesEmployee(String name, int birthMonth, int monthSalesVolume, double commissionRate, int leastSalary) {
        super(name, birthMonth, monthSalesVolume, commissionRate);
        this.leastSalary = leastSalary;
    }

    public int getLeastSalary() {
        return leastSalary;
    }

    public void setLeastSalary(int leastSalary) {
        this.leastSalary = leastSalary;
    }
    public void defaultSalary(){
        setSalary(leastSalary + getMonthSalesVolume() * getCommissionRate());
        getAllSalary();
        System.out.println(getSalary());
    }
}