package java100.app.domain;

import java.sql.Date;

public class Transaction {
    
    protected int no;
    protected int lenderNo; 
    protected int itemNo;
    protected int sellerNo;  
    protected String payMethod;   
    protected Date payDate;    
    protected int deliveryPayType;   
    protected String parcel;   
    protected String deliveryNo;      
    protected Boolean reviewState;
    protected Item item;
    
    @Override
    public String toString() {
        return "Transaction [no=" + no + ", lenderNo=" + lenderNo + ", itemNo=" + itemNo + ", sellerNo=" + sellerNo
                + ", payMethod=" + payMethod + ", payDate=" + payDate + ", deliveryPayType=" + deliveryPayType
                + ", parcel=" + parcel + ", deliveryNo=" + deliveryNo + ", reviewState=" + reviewState + ", item="
                + item + "]";
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getLenderNo() {
        return lenderNo;
    }

    public void setLenderNo(int lenderNo) {
        this.lenderNo = lenderNo;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getSellerNo() {
        return sellerNo;
    }

    public void setSellerNo(int sellerNo) {
        this.sellerNo = sellerNo;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public int getDeliveryPayType() {
        return deliveryPayType;
    }

    public void setDeliveryPayType(int deliveryPayType) {
        this.deliveryPayType = deliveryPayType;
    }

    public String getParcel() {
        return parcel;
    }

    public void setParcel(String parcel) {
        this.parcel = parcel;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public Boolean getReviewState() {
        return reviewState;
    }

    public void setReviewState(Boolean reviewState) {
        this.reviewState = reviewState;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    
    
    
    
    
   
    
    
    
    
}
