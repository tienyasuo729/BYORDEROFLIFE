import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(Validate.checkIntInPut("^[1-9]\\d*$", "- Enter n: ", "- Can only contain positive integers, please re-enter: "));
        System.out.println(n);
    }
}