package prefixsum.backjoon;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class prob3020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int h = scanner.nextInt();
        int[] up = new int[h+1];
        int[] down = new int[h+1];

        for (int i = 0; i < n; i++) {
            if(i%2==0){
                up[scanner.nextInt()]++;
            }else {
                down[scanner.nextInt()]++;
            }
        }
        for (int i = up.length-2; i>=1;i--) {
            up[i]+=up[i+1];
            down[i]+=down[i+1];
        }
        for (int i = 1; i < h+1; i++) {
            up[i] = up[i] + down[h+1-i];
        }
        Arrays.sort(up);
        int count = 0;
        for (int i = 1; i < up.length; i++) {
            if(up[i]==up[1])count++;
            else break;
        }
        System.out.println(up[1]+" "+count);
    }
}
