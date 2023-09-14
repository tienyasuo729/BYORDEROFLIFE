package JPD;

public class Practice {
    public static void main(String[] args) {
//        String list1 = "a,i,u,e,o,ka,ki,ku,ke,ko,sa,shi,su,se,so,ta,chi,tsu,te,to,na,ni,nu,ne,no,ha,hi,fu,he,ho,ma,mi,mu,me,mo,ya,yu,yo,ra,ri,ru,re,ro,wa,o";
        String list1 = "a,i,u,e,o,ka,ki,ku,ke,ko,sa,shi,su,se,so";
        String translate = "あ,い,う,え,お,か,き,く,け,こ,さ,し,す,せ,そ";
        int randomindex;
        int [] tran = {1,2,3};
        String [] a = list1.split(",");
        String [] b = translate.split(",");
        for (int i = 1; i <= 20; i++) {
            System.out.print("\n" + i + ". ");
            for (int j = 0; j < 3; j++) {
                randomindex = (int) (Math.random()*(a.length));
                tran[j] = randomindex;
                System.out.print(a[randomindex]);
            }
            System.out.println();
            for (int j = 0; j < tran.length; j++) {
                System.out.print(b[tran[j]]);
            }

        }
    }
}
