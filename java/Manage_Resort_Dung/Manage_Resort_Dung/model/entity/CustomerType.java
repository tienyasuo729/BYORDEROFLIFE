package model.entity;

public class CustomerType {
    private int id;
    private String nameType;
    public CustomerType(int id,String nameType) {
        this.id=id;
        this.nameType = nameType;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNameType() {
        return nameType;
    }
    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
    
}
