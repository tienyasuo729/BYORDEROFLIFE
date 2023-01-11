package test;

public class test {
    public static void main(String[] args) {
//        int x = 1;
//        while (true){
//            System.out.println(x);
//            x++;
//            if (x == 50){
//                break;
//            }
//        }

//        String nn = "123456789ggg";
//        System.out.println(nn.length());

//        int nn = 123123123;
//        String mm = String.valueOf(nn);
//        System.out.println(mm);

//        String nn = "1231231223423434234234242323423423423423";
//        int x = 2;
//        System.out.println(nn.length() > x);

        String nn = "abcd";
        char [] checkForLettersInput = nn.toCharArray();
        for (int i = 0; i < nn.length(); i++) {
            System.out.println(Character.isLetter(checkForLettersInput[i]));
        }

    }
}
