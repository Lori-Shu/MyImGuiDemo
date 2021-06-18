public class Homework12{
    public static void main(String[] args){
                Account janeSmith = new Account("Jane Smith",1000,2000,1.23);
                janeSmith.deposit(100);
                janeSmith.withdraw(960);
                janeSmith.withdraw(2000);
                System.out.println("账户主： "+janeSmith.getName()+" 存在账户： id： "+janeSmith.getId()+" 余额： "+janeSmith.getBalance()+" 年利率： "+janeSmith.getAnnualInterestRate());
    }
}
class Account{
    private String name;
    private int id;
    private double balance;
    private double annualInterestRate;
    public Account(String name,int id, double balance,double annualInterestRate){
        this.name=name;
        this.id=id;
        this.balance=balance;
        this.annualInterestRate=annualInterestRate;
    }
    public void setName(String name){

        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setId(int id){

        this.id=id;
    }
    public int getId(){

        return id;
    }
    public void setBalance(double balance){

        this.balance=balance;
    }
    public double getBalance(){

        return balance;
    }public void setAnnualInterestRate(double annualInterestRate){

        this.annualInterestRate=annualInterestRate;
    }
    public double getAnnualInterestRate(){

        return annualInterestRate;
    }
    public void withdraw(double withdraw){
        if(withdraw>balance){
            System.out.println("余额不足，取钱失败");
        }
        else {
            balance = balance - withdraw;
            System.out.println("成功取出 "+withdraw);
        }
    }
    public void deposit(double deposit){
        balance=balance+deposit;
        System.out.println("成功存入 "+deposit);
    }
}