package FuramaResort.Models;

public class Customer extends Person{
    private int numberPartner;

    public Customer(int cccd, String name, int age, String gender, int numberPartner) {
        super(cccd, name, age, gender);
        this.numberPartner = numberPartner;
    }

    @Override
    public void howToMove(String move) {
        System.out.println(move);
    }
}
