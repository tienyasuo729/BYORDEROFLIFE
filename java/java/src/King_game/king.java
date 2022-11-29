package King_game;

public class king extends People {
    static String powerOfTheKing = "Người trị vì 1 nước";

    public king(String name, int age, int height, int weight) {
        super(name, age, height, weight);
    }

    void command(String mission){
        System.out.println("Vua ra lệnh là : " + mission);
    }
    @Override
    void howToMove() {
        System.out.println("Đi bằng kiệu");
    }

}
