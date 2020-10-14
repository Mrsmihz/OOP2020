import java.util.Random;

public class Main {
    public static void main(String args[]){
        test3();
    }
    public static void test1(){
        Bank mybank = new Bank();
        Account acct1 = new Account(5000, "Sommai");
        Account acct2 = new Account(3000, "Somchai");
        Account acct3 = new Account(900, "Somsri");
        mybank.addAccount(acct1);
        mybank.addAccount(acct2);
        mybank.addAccount(acct3);
        System.out.println(mybank.getNumAccount());
        mybank.getAccount(0).showAccount();
        mybank.getAccount(0).withdraw(100);
        mybank.getAccount(1).deposit(555);
        mybank.getAccount(0).deposit(500);
        mybank.getAccount(2).deposit(500);

        for (int i=0;i<mybank.getNumAccount();i++){
            mybank.getAccount(i).showAccount();
        }
    }
    public static void test2(){
        Customer c1 = new Customer("John", "Smith");
        for (int i=0;i<5;i++){
            Account acct = new Account(new Random().nextInt((10000-1000)+1)+1000, "John");
            acct.showAccount();
            c1.addAccount(acct);
        }
        c1.getAccount(0).withdraw(100);
        c1.getAccount(1).deposit(10000);
        System.out.println(c1);
        for (int i=0;i<c1.getNumOfAccount();i++){
            c1.getAccount(i).showAccount();
        }
    }
    public static void test3(){
        Customer2 c1 = new Customer2("John", "Smith");
        for (int i=0;i<10;i++){
            Account acct = new Account(new Random().nextInt((10000-1000)+1)+1000, "John");
            c1.addAccount(acct);
        }
        System.out.println(c1);
        for (int i=0;i<c1.getNumOfAccount();i++){
            c1.getAccount(i).showAccount();
        }
    }
}
