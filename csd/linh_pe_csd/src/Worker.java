public class Worker implements Comparable<Worker>{
    private int key;
    private String name;
    private int age;

    public Worker(int key, String name, int age) {
        this.key = key;
        this.name = name;
        this.age = age;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
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
        return "Worker{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Worker o) {
        if (this.key < o.getKey()) return -1;
        if (this.key > o.getKey()) return 1;
        return 0;
    }
}
