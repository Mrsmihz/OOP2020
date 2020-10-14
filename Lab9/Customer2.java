import java.util.*;
public class Customer2 {
    private String firstname;
    private String lastname;
    private ArrayList<Account> acct;
    public Customer2(){
        this("", "");
    }
    public Customer2(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
        this.acct = new ArrayList<Account>();
    }
    public void setFirstName(String firstname){
        this.firstname = firstname;
    }
    public void setLastName(String lastname){
        this.lastname = lastname;
    }
    public String getFirstName(){
        return this.firstname;
    }
    public String getLastName(){
        return this.lastname;
    }
    public String toString(){
        if (acct != null){
            String s2 = String.format("%s %s has %d accounts", this.firstname, this.lastname, this.acct.size());
            return s2;
        }
        else{
            String s1 = String.format("%s %s doesn't have account.", this.firstname, this.lastname);
            return s1;
        }
    }
    public void addAccount(Account ac){
        this.acct.add(ac);
    }
    public Account getAccount(int index){
        return this.acct.get(index);
    }
    public int getNumOfAccount(){
        return this.acct.size();
    }
}
