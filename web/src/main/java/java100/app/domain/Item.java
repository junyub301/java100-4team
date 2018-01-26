package java100.app.domain;

import java.sql.Date;

public class Item {
    protected int itemNo;
    protected int ur_no;
    protected int categoryNo;
    protected int userType;
    protected String name;
    protected String title;
    protected String cnt;
    protected Date startDate;
    protected Date endDate;
    protected int price;
    protected int pricePerDay;
    protected boolean status;
    
    public Item() {}
    
    @Override
    public String toString() {
        return "Item [itemNo=" + itemNo + ", ur_no=" + ur_no + ", categoryNo=" + categoryNo + ", userType=" + userType
                + ", name=" + name + ", title=" + title + ", cnt=" + cnt + ", startDate=" + startDate + ", endDate="
                + endDate + ", price=" + price + ", pricePerDay=" + pricePerDay + ", status=" + status + "]";
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getUr_no() {
        return ur_no;
    }

    public void setUr_no(int ur_no) {
        this.ur_no = ur_no;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
