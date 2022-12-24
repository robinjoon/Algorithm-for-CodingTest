package prefixsum.backjoon;

import java.util.Scanner;

public class prob2559 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] sum = new int[n+1];
        sum[0] = 0;
        sum[1] = scanner.nextInt();
        for (int i = 2; i < n+1; i++) {
            sum[i] = sum[i-1]+ scanner.nextInt();
        }
        int pointer = k;
        int max = Integer.MIN_VALUE;
        while (pointer<=n){
            max = Math.max(max,sum[pointer]-sum[pointer-k]);
            pointer++;
        }
        System.out.println(max);
    }
}
