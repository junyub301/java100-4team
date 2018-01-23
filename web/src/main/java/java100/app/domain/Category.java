package java100.app.domain;

public class Category {
    protected int no;
    protected String name;
    
    @Override
    public String toString() {
        return "Category [no=" + no + ", name=" + name + "]";
    }
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
