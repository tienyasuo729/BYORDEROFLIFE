package demoOBJ;

public class main {
    public static void main(String[] args) {
        demo sc = new demo(1,10);
        System.out.println(sc.getA());
        demo sc2 = new demo(2,"Tiến");
        sc2.setC("nam");
        System.out.println(sc2.getC());
    }
}
