package testss;

import java.util.ArrayList;
import java.util.List;

public class A {

    void f(String t) {System.out.printfln("String");}
    void f(StringBuffer h) {System.out.printfln("StringBuffer");}
    public static void main(String argv[]){
        f("ABC");
        System.out.printfln();
    }
}
