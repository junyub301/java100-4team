package java100.app.domain;

import java.sql.Date;

public class Transaction {
    
    protected int no;
    protected int lenderNo; //userNo
    protected int itemNo;
    protected Date requestDate;  // 신청일
    protected int payMethod;   // 결제유형
    protected Date payDate;    // 결제일
    protected int deliveryPayType;   //배송비결제유형
    protected int deliveryNo;      //운송장 번호
    protected Date deliveryDate;    //배송일
    
    
    @Override
    public String toString() {
        return "Transaction [no=" + no + ", lenderNo=" + lenderNo + ", itemNo=" + itemNo + ", requestDate="
                + requestDate + ", payMethod=" + payMethod + ", payDate=" + payDate + ", deliveryPayType="
                + deliveryPayType + ", deliveryNo=" + deliveryNo + ", deliveryDate=" + deliveryDate + "]";
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

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
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

    public int getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(int deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
    
    
}
