import java.util.Scanner;

public class demoMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập : ");
        int x = Integer.parseInt(scanner.nextLine());
        int x1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int x3 = Integer.parseInt(scanner.nextLine());
        switch (x) {
            case 2 :
                System.out.print(lan1(x1,x2));
                break;
            case 3 :
                System.out.print(lan2(x1,x2,x3));
                break;
            case 4 :
                lan3();
                break;
        }
    }
    private static int lan1 (int x1, int x2) {
        return x1 +  x2;
    }

    private static int lan2 (int x1, int x2, int x3) {
        return x1 + x2 + x3;
    }

    private static void lan3 () {
        System.out.print("ádadasdada");
    }
}
