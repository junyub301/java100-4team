package java100.app.domain;

import java.util.Date;

public class Item {
    protected int itemNo;
    protected int userNo;
    protected int category;
    protected int userType;
    protected String name;
    protected String title;
    protected String content;
    protected Date startDate;
    protected Date endDate;
    protected int price;
    protected int pricePerDay;
    protected boolean status;
    protected String filename;
    protected Photo photos;
    protected User writer;
    
    @Override
    public String toString() {
        return "Item [itemNo=" + itemNo + ", userNo=" + userNo + ", title=" + title + ", name=" + name + ", content="
                + content + ", startDate=" + startDate + ", endDate=" + endDate + ", price=" + price + ", pricePerDay="
                + pricePerDay + ", status=" + status + ", category=" + category + ", userType=" + userType
                + ", filename=" + filename + "]";
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
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
    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
    }
    public int getUserType() {
        return userType;
    }
    public void setUserType(int userType) {
        this.userType = userType;
    }
    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
   
    
    
    
    
}
