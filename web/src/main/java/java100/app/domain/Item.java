package java100.app.domain;

import java.sql.Date;

public class Item {
    protected int itemNo;
    protected int userNo;
    protected int categoryNo;
    protected String title;
    protected String name;
    protected Date startDate;
    protected Date endDate;
    protected int price;
    protected int pricePerDay;
    protected boolean status;
    
    public Item() {}
    
    public Item(int itemNo, int userNo, int catetegoryNo, 
            String title, String name, Date startDate,
            Date endDate, int price, int pricePerDay, boolean status) {
        this.itemNo = itemNo;
        this.userNo = userNo;
        this.categoryNo = catetegoryNo;
        this.title = title;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.pricePerDay = pricePerDay;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item [itemNo=" + itemNo + ", userNo=" + userNo + ", categoryNo=" + categoryNo + ", title=" + title
                + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + ", price=" + price
                + ", pricePerDay=" + pricePerDay + ", status=" + status + "]";
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
