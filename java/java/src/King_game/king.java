package King_game;

public class king extends People {
    static String powerOfTheKing = "Người trị vì 1 nước";

    public king(String name, int age, int height, int weight) {
        super(name, age, height, weight);
    }

    @Override
    void howToMove() {
        System.out.println("Đi bằng xe ngưa");
    }
}
