package lecture1;


import java.util.Scanner;

public class Prob1213 {
    public static void main(String[] args) {
        int[] counts = new int['Z'-'A'+1];
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        for (char ch:str.toCharArray()) {
            counts[ch-'A']++;
        }
        int count = 0;
        char center='_';
        for (int i = 0;i<counts.length;i++) {
            int c = counts[i];
            if(c%2==1){
                count++;
                center = (char) ('A'+i);
            }
            if(count>1){
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]/2; j++) {
                sb.append((char) ('A'+i));
            }
        }
        if(center!='_'){
            System.out.println(sb.toString()+center+sb.reverse());
        }else {
            System.out.println(sb.toString()+sb.reverse());
        }
    }
}
