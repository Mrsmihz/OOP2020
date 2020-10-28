package Quiz2;

public class CheckingAccount extends Account{
    private double credit;
    public CheckingAccount(){
        this(0, "", 0);

    }
    public CheckingAccount(double balance, String name, double credit){
        super(balance, name);
        if (credit >= 0){
            setCredit(credit);
        }
        else{
            System.out.println("Input number must be a positive integer.");
        }
    }
    public void setCredit(double a){
        this.credit = a;
    }
    public double getCredit(){
        return this.credit;
    }
    public void withdraw(double a) throws WithdrawException{

        if (super.balance - a >= 0){
            super.balance -= a;
            System.out.printf("%.1f bath is withdrawn from %s and your credit balance is %.1f\n", a, super.name, this.credit);
        }
        else if (super.balance - a < 0){
            if ((super.balance - a) + this.credit >= 0){
                super.balance -= a;
                this.credit += super.balance;
                super.balance = 0;
                System.out.printf("%.1f bath is withdrawn from %s and your credit balance is %.1f\n", a, super.name, this.credit);
            }
            else if ((super.balance - a) + this.credit < 0){
                throw new WithdrawException(String.format("Account %s has not enough money.", getName()));
            }
        }
    }
    public void withdraw(int a) throws WithdrawException{

        if (super.balance - a >= 0){
            super.balance -= a;
            System.out.printf("%.1f bath is withdrawn from %s and your credit balance is %.1f\n", a, super.name, this.credit);
        }
        else if (super.balance - a < 0){
            if ((super.balance - a) + this.credit > 0){
                super.balance -= a;
                this.credit += super.balance;
                super.balance = 0;
                System.out.printf("%.1f bath is withdrawn from %s and your credit balance is %.1f\n", (double)a, super.name, this.credit);
            }
            else if ((super.balance - a) + this.credit < 0){
                throw new WithdrawException(String.format("Account %s has not enough money.", getName()));
            }
        }
    }
    public String toString(){
        String s1 = String.format("The %s account has %.1f baht and %.1f credits", super.name, super.balance, this.credit);
        return s1;
    }
}
