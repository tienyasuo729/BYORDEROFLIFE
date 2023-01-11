package obj;


import java.util.Scanner;

public class QuadraticEquation {
    double a;
    double b;
    double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {return b; }

    public double getC() {
        return c;
    }

    private double getDiscriminant() {
        return (this.b * this.b - 4 * this.a * this.c);
    }

    private double getRoot1() {
        return (-this.b + Math.sqrt(this.getDiscriminant())) / (2 * this.a);
    }

    private double getRoot2() {
        return (-this.b - Math.sqrt(this.getDiscriminant())) / (2 * this.a);
    }

    private double getRoob3() {return (-this.b / (2 * this.a));}

    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);
        System.out.print("Nhập giá trị A của phương trình bậc 2 ( ax2 + bx + x = 0) : ");
        double a = Double.parseDouble(insert.nextLine());
        System.out.print("Nhập giá trị B của phương trình bậc 2 ( ax2 + bx + x = 0) : ");
        double b = Double.parseDouble(insert.nextLine());
        System.out.print("Nhập giá trị C của phương trình bậc 2 ( ax2 + bx + x = 0) : ");
        double c = Double.parseDouble(insert.nextLine());
        QuadraticEquation expression = new QuadraticEquation(a,b,c);
        System.out.print(expression.getDiscriminant());
        if (expression.getDiscriminant() > 0 ) {
            System.out.print("Phương trình có 2 nghiệm : r1 = " + expression.getRoot1() + " r2 = " + expression.getRoot2());
        }else if (expression.getDiscriminant() == 0 ) {
            System.out.print("Phương trình có 1 nghiệm = " + expression.getRoob3());
        }else {
            System.out.print("Phương trình vô nghiệm");
        }
    }
}
