package demoOBJ;

public class demo {
    private int a;
    private int b;
    private String c;
    public demo(int a, int b){
        this.a = a;
        this.b = b;
    }
    public demo(int a, String c){
        this.a = a;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
