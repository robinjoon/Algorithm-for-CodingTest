package lecture1;

import java.util.Scanner;

public class Prob10988 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuffer sb = new StringBuffer(str);
        String str2 = sb.reverse().toString();
        if(str.contentEquals(str2)){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}
