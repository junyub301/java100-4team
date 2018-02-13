package java100.app.domain;

import java.sql.Date;

public class Message {
    protected int messageNo;
    protected int userNo;
    protected String title;
    protected String content;
    protected boolean state;
    protected Date dispatchDate;
   
    @Override
    public String toString() {
        return "Message [messageNo=" + messageNo + ", userNo=" + userNo + ", title=" + title + ", content=" + content
                + ", state=" + state + ", dispatchDate=" + dispatchDate + "]";
    }
    
    public int getMessageNo() {
        return messageNo;
    }
    public void setMessageNo(int messageNo) {
        this.messageNo = messageNo;
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean isState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public Date getDispatchDate() {
        return dispatchDate;
    }
    public void setDispatchDate(Date dispatchDate) {
        this.dispatchDate = dispatchDate;
    }
   
    
    
    
    
}
