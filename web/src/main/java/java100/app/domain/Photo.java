package java100.app.domain;

public class Photo {
    int no;
    String photoName;
    String thumbnailName;
    int itemNo;
    int userNo;
    
    public Photo() {}
    
    public Photo(String photoName) {
        this.photoName = photoName;
    }
    
    public Photo(String photoName, String thumbnailName) {
        this.photoName = photoName;
        this.thumbnailName = thumbnailName;
    }

    @Override
    public String toString() {
        return "Photo [no=" + no + ", photoName=" + photoName + ", thumbnailName=" + thumbnailName + ", itemNo="
                + itemNo + ", userNo=" + userNo + "]";
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

    public String getThumbnailName() {
        return thumbnailName;
    }

    public void setThumbnailName(String thumbnailName) {
        this.thumbnailName = thumbnailName;
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
