package java100.app.domain;

public class Maps {
    protected int MapNo;
    protected String address;
    protected double latitude;
    protected double longitude;
    protected int userNo;
    protected int itemNo;
    
    @Override
    public String toString() {
        return "Maps [MapNo=" + MapNo + ", address=" + address + ", latitude=" + latitude + ", longitude=" + longitude
                + ", userNo=" + userNo + ", itemNo=" + itemNo + "]";
    }

    public int getMapNo() {
        return MapNo;
    }

    public void setMapNo(int mapNo) {
        MapNo = mapNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }
   
    
    
    
    
    
    
}
