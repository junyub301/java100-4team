package java100.app.domain;

public class Photo {
    int no;
    String photoPath;
    int itemNo;
    
    @Override
    public String toString() {
        return "Photo [no=" + no + ", photoPath=" + photoPath + ", itemNo=" + itemNo + "]";
    }
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getPhotoPath() {
        return photoPath;
    }
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    public int getItemNo() {
        return itemNo;
    }
    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }


}
