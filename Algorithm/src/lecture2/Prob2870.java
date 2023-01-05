package lecture2;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Prob2870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<BigInteger> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.addAll(findNums(sc.next()));
        }
        Collections.sort(result);
        result.forEach(System.out::println);
    }
    private static List<BigInteger> findNums(String str){
        int s =0,e=0;
        List<BigInteger> ret = new ArrayList<>();
        char[] chars = str.toCharArray();
        while (s<str.length() && e<str.length()){
            if(isNum(chars[s])){
                while (e<str.length() && isNum(chars[e])){
                    e++;
                }
                String result = str.substring(s,e);
                ret.add(new BigInteger(result));
                s = e;
            }else {
                s++;e++;
            }
        }
        return ret;
    }
    private static boolean isNum(char c){
        return c>='0' &&c<='9';
    }
}
