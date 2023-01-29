package TiemCamDoTienThanh.Model;

public class Customer implements Comparable<Customer>{
    private String cccd;
    private String name;
    private int id;
    private String product;
    private int price;
    private int day;
    private int month;
    private int years;
    private String phoneNumber;
    private String lincePlates;

    // Điện thoại
    public Customer(int id, String name, String product, int price, int day, int month, int years, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.product = product;
        this.price = price;
        this.day = day;
        this.month = month;
        this.years = years;
        this.phoneNumber = phoneNumber;
    }

    // xe máy
    public Customer(int id, String cccd, String name, String product, String lincePlates , int price, int day, int month, int years, String phoneNumber) {
        this.id = id;
        this.cccd = cccd;
        this.name = name;
        this.product = product;
        this.lincePlates = lincePlates;
        this.price = price;
        this.day = day;
        this.month = month;
        this.years = years;
        this.phoneNumber = phoneNumber;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLincePlates() {
        return lincePlates;
    }

    public void setLincePlates(String lincePlates) {
        this.lincePlates = lincePlates;
    }

    @Override
    public int compareTo(Customer o) {
        return this.getId() - o.getId();
    }
}
