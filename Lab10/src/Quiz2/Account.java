package Quiz2;

public class Account{
    protected double balance;
    protected String name;

    public Account(double balance, String name){
        this.balance = balance;
        setName(name);
    }
    public void deposit(double a){
        if (a > 0){
            this.balance += a;
            System.out.printf("%.1f baht is deposited to %s.\n", a, name);
        }
        else{
            System.out.println("Input number must be a positive integer.");
        }
    }
    public void withdraw(double a) throws WithdrawException{
        if (a > 0 && balance - a > 0){
            this.balance -= a;
            System.out.printf("%.1f baht is withdrawn from %s.\n", a, name);
        }
        else if (a < 0){
            System.out.println("Input number must be a positive integer.");
        }
        else if ((balance - a) < 0){
            System.out.println("Not enough money!");
        }
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public double getBalance(){
        return this.balance;
    }
    public void showAccount(){
        System.out.printf("%s account has %.1f baht\n", name, balance);
    }
}
