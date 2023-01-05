package lecture2;

import java.util.Scanner;

public class Prob4659 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        while (!str.contentEquals("end")){
            if(checkaeiou(str) && check2(str) && check3(str)){
                System.out.printf("<%s> is acceptable.\n",str);
            }else{
                System.out.printf("<%s> is not acceptable.\n",str);
            }
            str = sc.next();
        }
    }
    private static boolean checkaeiou(String s){
        return s.contains("a") ||s.contains("e")||s.contains("i")||s.contains("o")||s.contains("u");
    }
    private static boolean check3(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length-2; i++) {
            int count1 = 0;
            int count2 = 0;
            for (int j = i; j < i+3; j++) {
                char c = chars[j];
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                    count1++;
                }else {
                    count2++;
                }
            }
            if(count1==3 || count2==3){
                return false;
            }
        }
        return true;
    }
    private static boolean check2(String s){
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length-1; i++) {
            if(chars[i]==chars[i+1]){
                if(!(chars[i]=='e'||chars[i]=='o')){
                    return false;
                }
            }
        }
        return true;
    }
}
