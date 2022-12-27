package prefixsum.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Prob14465 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int b = scanner.nextInt();
        int[] arr = new int[n+1];
        Arrays.fill(arr,1);
        arr[0] =0;
        for (int i = 0; i < b; i++) {
            arr[scanner.nextInt()] = 0;
        }
        for (int i = 1; i < n+1; i++) {
            arr[i] += arr[i-1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = k; i < n+1; i++) {
            int pSum = arr[i] - arr[i-k];
            min = Math.min(min,k-pSum);
        }
        System.out.println(min);
    }
}
