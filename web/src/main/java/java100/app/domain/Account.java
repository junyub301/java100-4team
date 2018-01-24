package java100.app.domain;

public class Account {
  protected  int accountsNo;
  protected  String accountName;
  protected  String name;
  protected  String email;
  protected  String password;
  protected  int rank;
@Override
public String toString() {
    return "Account [accountsNo=" + accountsNo + ", accountName=" + accountName + ", name=" + name + ", email=" + email
            + ", password=" + password + ", rank=" + rank + "]";
}
public int getAccountsNo() {
    return accountsNo;
}
public void setAccountsNo(int accountsNo) {
    this.accountsNo = accountsNo;
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
