package lecture2;

import java.util.Scanner;

public class prob2828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        int start = 0;
        int end = m;
        for (int i = 0; i < k; i++) {
            int apple = sc.nextInt()-1;
            if(apple<start){
                int diff = start-apple;
                count += diff;
                start = start - diff;
                end = end - diff;
            }else if(apple>=end){
                int diff = apple+1 - end;
                end +=diff;
                start+=diff;
                count+=diff;
            }
        }
        System.out.print(count);
    }
}
