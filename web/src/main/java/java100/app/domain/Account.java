package java100.app.domain;

public class Account {
  protected  int accountNo;
  protected  String accountName;
  protected  String name;
  protected  String email;
  protected  String password;
  protected  int rank;
    

    public Account() {}
    public Account(int accountNo, String accountName ,String name,String email, String password,int rank) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rank =rank;
    }
    
    
    @Override
    public String toString() {
        return "Account [accountNo=" + accountNo + ", accountName=" + accountName + ", name=" + name + ", email="
                + email + ", password=" + password + ", rank=" + rank + "]";
    }
    public int getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    
    
}
