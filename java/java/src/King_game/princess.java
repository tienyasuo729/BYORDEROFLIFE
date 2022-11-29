package King_game;

public class princess extends People {
    static String beautiful = "Xinh đẹp nhất vương quốc";

    public princess(String name, int age, int height, int weight) {
        super(name, age, height, weight);
    }
    void comment (String comment) {
        System.out.println("Nhận xét của công chúa : " + comment);
    }

    @Override
    void howToMove() {
        System.out.println("Đi với vua");
    }

}
