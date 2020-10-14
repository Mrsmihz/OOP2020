public class Customer {
    private String firstname;
    private String lastname;
    //private CheckingAccount acct;
    private Account acct[];
    private int numOfAccount;
    public Customer(){
        this("", "");
    }
    public Customer(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
        this.acct = new Account[5];
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
            String s2 = String.format("%s %s has %d accounts", this.firstname, this.lastname, this.numOfAccount);
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
    public void addAccount(Account ac){
        this.acct[numOfAccount++] = ac;
    }
    public Account getAccount(int index){
        return this.acct[index];
    }
    public int getNumOfAccount(){
        return this.numOfAccount;
    }
}
