package FuramaResort.Models;

public abstract class Person {
    private int cccd;
    private String name;
    private int age;
    private String gender;

    public Person(int cccd, String name, int age, String gender) {
        this.cccd = cccd;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getCccd() {
        return cccd;
    }

    public void setCccd(int cccd) {
        this.cccd = cccd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public abstract void howToMove(String move);
}
