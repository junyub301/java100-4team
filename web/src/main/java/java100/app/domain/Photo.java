package java100.app.domain;

public class Photo {
    int no;
    String photoName;
    int itemNo;
    int userNo;
    
    public Photo() {}
    
    public Photo(String photoName) {
        this.photoName = photoName;
    }

    @Override
    public String toString() {
        return "Photo [no=" + no + ", photoName=" + photoName + ", itemNo=" + itemNo + ", userNo=" + userNo + "]";
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
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
    
    


}
