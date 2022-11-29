package King_game;

public abstract class knight extends People {
    private String weapon;

    public knight(String name, int age, int height, int weight, String weapon) {
        super(name, age, height, weight);
        this.weapon = weapon;
    }

    @Override
    void howToMove() {
        System.out.println("Di chuyển bằng ngựa");
    }
    void goOnDuty (String mission) {
        System.out.println("Đi làm nhiệm vụ : " + mission);
    }
    abstract void fight ();

    @Override
    public String toString() {
        return "knight{" +
                "weapon='" + weapon + '\'' +
                '}';
    }
}
