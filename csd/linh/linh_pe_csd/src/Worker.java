public class Worker{
    int key;
    String name;
    int age;

    public Worker(int key, String name, int age) {
        this.key = key;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Key: " + key + ", Name: " + name + ", Age: " + age;
    }
}
