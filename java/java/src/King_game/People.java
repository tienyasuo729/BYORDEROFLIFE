package King_game;

public abstract class People {
    private String name;
    private String age;
    private int height;
    private int weight;
    public People(String name, String age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    abstract void howToMove();

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "people{" +
                "tên ='" + name + '\'' +
                ", tuổi ='" + age + '\'' +
                ", chiều cao =" + height +
                ", cân nặng =" + weight +
                '}';
    }
}
