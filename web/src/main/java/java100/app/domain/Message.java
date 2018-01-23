package java100.app.domain;

import java.sql.Date;

public class Message {
    protected  int messageNo;
    protected  int userNo1;
    protected  int userNo2;
    protected  String title;
    protected  String content;
    protected  boolean state;
    protected  Date dispatchDate;
    
    public Message() {}
    
    public Message(int messageNo, int userNo1, int userNo2, String title, String content,boolean state,Date dispatchDate ) {
        this.messageNo = messageNo;
        this.userNo1 = userNo1;
        this.userNo2 = userNo2;
        this.title = title;
        this.content = content;
        this.state = state;
        this.dispatchDate =dispatchDate;
    }
    

    @Override
    public String toString() {
        return "Message [messageNo=" + messageNo + ", userNo1=" + userNo1 + ", userNo2=" + userNo2 + ", title=" + title
                + ", content=" + content + ", state=" + state + ", dispatchDate=" + dispatchDate + "]";
    }

    public int getMessageNo() {
        return messageNo;
    }

    public void setMessageNo(int messageNo) {
        this.messageNo = messageNo;
    }

    public int getUserNo1() {
        return userNo1;
    }

    public void setUserNo1(int userNo1) {
        this.userNo1 = userNo1;
    }

    public int getUserNo2() {
        return userNo2;
    }

    public void setUserNo2(int userNo2) {
        this.userNo2 = userNo2;
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
