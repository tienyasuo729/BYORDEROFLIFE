import java.util.Random;

public class testRandom {


    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(1000);
        int sp = number;
        int count = 0;
        int chan = 0;
        int le = 0;
        for (int i = 0; i < 2;) {
            number = random.nextInt(1000);
            if (number % 2 == 0){
                chan++;
            }else {
                le++;
            }
            if(sp == number){
                System.out.println(sp);
                break;
            }else {
                System.out.println(number);
                count++;
            }
        }
        System.out.println("---" + count + "---");
        System.out.println("---" + chan + "---");
        System.out.println("---" + le + "---");
    }
}
