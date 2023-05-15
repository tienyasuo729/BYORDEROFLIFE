import java.util.Arrays;
import java.util.Scanner;

public class cc {
    private static Scanner scanner = new Scanner(System.in);
        public void main(String args[]) {
    //        int sp;
           int [] a = {9,5,3,11,7};
    //       Arrays.sort(a);
    //        for (int i = 0; i < a.length; i++) {
    //            for (int j = 0; j < a.length; j++) {
    //              if (a[i] > a[j]){
    //                  sp = a[j];
    //                  a[j] = a[i];
    //                  a[i] = sp;
    //              }
    //            }
    //        }
    //        System.out.println(Arrays.toString(a));

            sort(a);
        }

        private static void sort(int [] a){
            int sp;
            for (int i = 0; i < a.length; i++) {
                for (int j = i+1; j < a.length; j++) {
                    if (a[i] > a[j]){
                        sp = a[j];
                        a[j] = a[i];
                        a[i] = sp;
                    }
                }
            }
            System.out.println(Arrays.toString(a));

        }
}
