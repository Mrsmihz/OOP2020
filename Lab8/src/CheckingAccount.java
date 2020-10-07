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
    @Override
    public boolean withdraw(double a){
        if (super.balance - a >= 0){
            super.balance -= a;
            return true;
            //System.out.printf("%.1f bath is withdrawn from %s and your credit balance is %.1f\n", a, super.name, this.credit);
        }
        else if (super.balance - a < 0){
            if ((super.balance - a) + this.credit >= 0){
                a -= super.balance;
                super.balance = 0;
                this.credit -= a;
                return true;
                //System.out.printf("%.1f bath is withdrawn from %s and your credit balance is %.1f\n", a, super.name, this.credit);
            }
            else if ((super.balance - a) + this.credit < 0){
                return false;
                // System.out.println("Not enough money!");
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    public boolean withdraw(int a){
        if (super.balance - a >= 0){
            super.balance -= a;
            return true;
            //System.out.printf("%d bath is withdrawn from %s and your credit balance is %.1f\n", a, super.name, this.credit);
        }
        else if (super.balance - a < 0){
            if ((super.balance - a) + this.credit > 0){
                a -= super.balance;
                super.balance = 0;
                this.credit -= a;
                return false;
                //System.out.printf("%d bath is withdrawn from %s and your credit balance is %.1f\n", a, super.name, this.credit);
            }
            else if ((super.balance - a) + this.credit < 0){
                return false;
                //System.out.println("Not enough money!");
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    public String toString(){
        return String.format("The %s account has %.1f baht and %.1f credits", super.name, super.balance, this.credit);
    }
}
