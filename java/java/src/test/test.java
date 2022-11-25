package test;

public class test {
    int a;
    int b;

    private static String school = "code";

    private test (int a, int b){
        this.a = a;
        this.b = b;

    }

    @Override
    public String toString() {
        return "test.test{" +
                "a=" + a +
                ", b=" + b +
                "school = " + school +
                '}';
    }

    public static void main(String[] args) {
        test sc = new test(1,3);
        System.out.println(sc);
    }
}
