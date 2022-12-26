package prefixsum.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Prob21758 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        long[] sum = new long[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = arr[i]+sum[i-1];
        }
        long total = Arrays.stream(arr).mapToLong(i->i).sum();
        long max=0;
        for (int i = 1; i < n-1; i++) {
            long tmp = total - arr[0];
            tmp = tmp + sum[n-1] - sum[i];
            tmp = tmp - arr[i];
            max = Math.max(tmp,max);
        }
        for (int i = 1; i < n-1; i++) {
            long tmp = total - arr[n-1];
            tmp = tmp + sum[i-1];
            tmp = tmp - arr[i];
            max = Math.max(tmp,max);
        }
        for (int i = 1; i < n-1; i++) {
            long tmp = sum[i] - sum[0] + sum[n-2] -sum[i-1];
            max = Math.max(tmp,max);
        }
        System.out.println(max);
    }
}
