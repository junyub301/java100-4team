package java100.app.domain;

import java.sql.Date;
import java.util.List;

public class Item { 
    protected int itemNo;
    protected int userNo;
    protected String title;
    protected String name;
    protected String content;
    protected Date startDate;
    protected Date endDate;
    protected int price;
    protected int status;
    protected int category;
    protected int userType;
    protected List<Photo> photos;
    
    @Override
    public String toString() {
        return "Item [itemNo=" + itemNo + ", userNo=" + userNo + ", title=" + title + ", name=" + name + ", content="
                + content + ", startDate=" + startDate + ", endDate=" + endDate + ", price=" + price + ", status="
                + status + ", category=" + category + ", userType=" + userType + ", photos=" + photos + "]";
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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
    
    
}
