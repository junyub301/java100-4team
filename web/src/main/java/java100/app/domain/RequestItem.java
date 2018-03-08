package java100.app.domain;

import java.sql.Date;

public class RequestItem {
    
    protected int requestNo;
    protected String title;
    protected String content;
    protected String itemName;
    protected Date regDate;
    protected int userNo;
    
    @Override
    public String toString() {
        return "Request [requestNo=" + requestNo + ", title=" + title + ", content=" + content + ", itemName="
                + itemName + ", regDate=" + regDate + ", userNo=" + userNo + "]";
    }

    public int getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(int requestNo) {
        this.requestNo = requestNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }
    
    
}
