package JPD;

import java.sql.Array;

public class Practice {
    public static void main(String[] args) {
//        String list1 = "a,i,u,e,o,ka,ki,ku,ke,ko,sa,shi,su,se,so,ta,chi,tsu,te,to,na,ni,nu,ne,no,ha,hi,fu,he,ho,ma,mi,mu,me,mo,ya,yu,yo,ra,ri,ru,re,ro,wa,o";
        String translate;
        String list1;
//        list1 = "a,i,u,e,o,ka,ki,ku,ke,ko,sa,shi,su,se,so,ta,chi,tsu,te,to";
//        translate = "あ,い,う,え,お,か,き,く,け,こ,さ,し,す,せ,そ,た,ち,つ,て,と";

//        list1 = "na,ni,nu,ne,no";
//        translate = "な,に,ぬ,ね,の";

        list1 = "ka,ki,ku,ke,ko,sa,shi,su,se,so,ta,chi,tsu,te,to,na,ni,nu,ne,no,ha,hi,fu,he,ho,ma,mi,mu,me,mo";
        translate = "か,き,く,け,こ,さ,し,す,せ,そ,た,ち,つ,て,と,な,に,ぬ,ね,の,は,ひ,ふ,へ,ほ,ま,み,む,め,も";

//        list1 = "na,ni,nu,ne,no,ha,hi,fu,he,ho,ma,mi,mu,me,mo,ya,yu,yo,ra,ri,ru,re,ro,wa,n";
//        translate = "な,に,ぬ,ね,の,は,ひ,ふ,へ,ほ,ま,み,む,め,も,や,ゆ,よ,ら,り,る,れ,ろ,わ,ん";
        int randomindex;
        int[] tran = new int[6];
        String[] a = list1.split(",");
        String[] b = translate.split(",");
        for (int i = 1; i <= 27; i++) {
            System.out.print("\n" + i + ". ");
            for (int j = 0; j < tran.length; j++) {
                randomindex = (int) (Math.random() * (a.length));
                tran[j] = randomindex;
                System.out.print(a[randomindex]);
            }
            System.out.println();

//            System.out.println();
//            for (int j = 0; j < tran.length; j++) {
//                System.out.print(b[tran[j]]);
//            }

        }
    }
}
