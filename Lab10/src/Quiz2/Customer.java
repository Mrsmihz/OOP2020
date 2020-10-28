package Quiz2;

public class Customer {
    private String firstname;
    private String lastname;
    private CheckingAccount acct;
    public Customer(){
        this("", "", null);
    }
    public Customer(String firstname, String lastname){
        this(firstname, lastname, null);
    }
    public Customer(String firstname, String lastname, CheckingAccount acct){
        setFirstName(firstname);
        setLastName(lastname);
        setAcct(acct);
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
    public void setAcct(CheckingAccount acct){
        this.acct = acct;
    }
    public CheckingAccount getAcct(){
        return this.acct;
    }
    public String toString(){
        if (acct != null){
            String s2 = String.format("The %s account has %.1f baht and %.1f credits", this.firstname, this.acct.getBalance(), this.acct.getCredit());
            return s2;
        }
        else{
            String s1 = String.format("%s %s doesn't have account.", this.firstname, this.lastname);
            return s1;
        }
    }
    public boolean equals(Customer c){
        if (this.firstname.equals(c.firstname) && this.lastname.equals(c.lastname)){
            return true;
        }
        else{
            return false;
        }
    }
}
