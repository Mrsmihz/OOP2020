package Quiz2;

public class Main {
    public static void main(String[] args){
        CheckingAccount acct1 = new CheckingAccount(1000, "A001", 500);
        Customer cust = new Customer("John", "Smith", acct1);
        try{
            cust.getAcct().deposit(500);
            cust.getAcct().withdraw(1800);
            cust.getAcct().withdraw(300);
        }
        catch (WithdrawException e){
            System.out.println(e);
        }
        finally {
            System.out.println("Thank you.");
        }
    }
}
