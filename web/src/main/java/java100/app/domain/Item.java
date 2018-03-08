package java100.app.domain;

import java.sql.Date;
import java.util.List;

public class Item { 
    protected int itemNo;
    protected int userNo;
    protected String title;
    protected String itemName;
    protected String content;
    protected Date regDate;
    protected Date startDate;
    protected Date endDate;
    protected int price;
    protected String dealAddress;
    protected float distance;
    protected int status;
    protected int category;
    protected int directOrPay;
    protected List<Photo> photos;
    
    @Override
    public String toString() {
        return "Item [itemNo=" + itemNo + ", userNo=" + userNo + ", title=" + title + ", itemName=" + itemName
                + ", content=" + content + ", regDate=" + regDate + ", startDate=" + startDate + ", endDate=" + endDate
                + ", price=" + price + ", dealAddress=" + dealAddress + ", distance=" + distance + ", status=" + status
                + ", category=" + category + ", directOrPay=" + directOrPay + ", photos=" + photos + "]";
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
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

    public String getDealAddress() {
        return dealAddress;
    }

    public void setDealAddress(String dealAddress) {
        this.dealAddress = dealAddress;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getDirectOrPay() {
        return directOrPay;
    }

    public void setDirectOrPay(int directOrPay) {
        this.directOrPay = directOrPay;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
    
    
    
    
    
}
