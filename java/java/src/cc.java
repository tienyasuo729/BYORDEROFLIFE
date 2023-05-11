import java.util.Scanner;

public class cc {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.print("- Nh?p vào ?ây tên c?a b?n: ");
        String name = checkIntInPut("^[\\p{L}\\s]+$", "Nh?p sai tên r?i, xin nh?p l?i: ");
        int age = Integer.parseInt(checkIntInPut("^[0-9]$)", "Không nhập chữ, xin vui lòng nh?p l?i: "));
        System.out.print("- Tên c?a b?n là : " + name + "\n-Tu?i c?a b?n là: " + age);

    }
    private static String checkIntInPut(String regex, String print) { // ki?m tra d? li?u nh?p vào có b? l?i v? c? tình nh?p ch? hay v??t ph?m vi int không { theo regex }
        String input = null;
        boolean check = true;
        do {
            input = scanner.nextLine();
            if (input.matches(regex)){
                check = false;
            }else {
                System.out.print(print);
            }
        }while (check);

        return input;
    }
}
