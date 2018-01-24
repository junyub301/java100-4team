package java100.app.domain;

public class User {  
    
    protected int userNo;
    protected String accountNo;
    protected String bank;
    protected String comment;
    protected String phone;
    protected String postNo;
    protected String baseAddress;
    protected String detailAddress;
 
    @Override
    public String toString() {
        return "User [userNo=" + userNo + ", accountNo=" + accountNo + ", bank=" + bank + ", comment=" + comment
                + ", phone=" + phone + ", postNo=" + postNo + ", baseAddress=" + baseAddress + ", detailAddress="
                + detailAddress + "]";
    }
    

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostNo() {
        return postNo;
    }
    

    public void setPostNo(String postNo) {
        this.postNo = postNo;
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
    
    
    
    
}
