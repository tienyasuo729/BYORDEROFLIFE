package FuramaResort.Model;

public abstract class People {
    private int cccd;
    private String name;
    private int age;

    public People(int cccd, String name, int age) {
        this.cccd = cccd;
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "people{" +
                "cccd=" + cccd +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public abstract void move();
}
