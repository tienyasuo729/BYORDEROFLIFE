package JPD;

public class Practice {
    public static void main(String[] args) {
        String list1 = "a,i,u,e,o,ka,ki,ku,ke,ko,sa,shi,su,se,so,ta,chi,tsu,te,to,na,ni,nu,ne,no,ha,hi,fu,he,ho,ma,mi,mu,me,mo,ya,yu,yo,ra,ri,ru,re,ro,wa,o";
        String translate = "あ,い,う,え,お";
        String [] a = list1.split(",");
        for (int i = 1; i <= 100; i++) {
            System.out.print("\n" + i + ". ");
            for (int j = 0; j < 5; j++) {
                String random = a[(int) (Math.random()*44)];
                System.out.print(random);
            }

        }
    }
}
