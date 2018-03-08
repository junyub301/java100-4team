package java100.app.domain;

import java.sql.Date;

public class Review {
    protected int rentNo;
    protected String contents;
    protected int star;
    protected int itemNo;
    protected Date createdDate;
    protected String userPic;
    protected String userName;
    
    @Override
    public String toString() {
        return "Review [rentNo=" + rentNo + ", contents=" + contents + ", star=" + star + ", itemNo=" + itemNo
                + ", createdDate=" + createdDate + ", userPic=" + userPic + ", userName=" + userName + "]";
    }

    public int getRentNo() {
        return rentNo;
    }

    public void setRentNo(int rentNo) {
        this.rentNo = rentNo;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    
    
    
}
