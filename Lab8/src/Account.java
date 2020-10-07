public class Account{
    protected double balance;
    protected String name;

    public Account(double balance, String name){
        this.balance = balance;
        this.name = name;
    }
    public boolean deposit(double a){
        if (a > 0){
            this.balance += a;
            //System.out.printf("%.1f baht is deposited to %s.\n", a, name);
            return true;
        }
        else{
            //System.out.println("Input number must be a positive integer.");
            return false;
        }
    }
    public boolean withdraw(double a){
        if (a > 0 && balance - a > 0){
            this.balance -= a;
            //System.out.printf("%.1f baht is withdrawn from %s.\n", a, name);
            return true;
        }
        else if (a < 0){
            //System.out.println("Input number must be a positive integer.");
            return false;
        }
        else if ((balance - a) < 0){
            //System.out.println("Not enough money!");
            return false;
        }
        else{
            return false;
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
