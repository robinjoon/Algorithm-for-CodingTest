package prefixsum.backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class prob1806 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int start = 0;
        int end = 0;
        int length = n;
        int sum = 0;
        if(Arrays.stream(arr).sum()<s){
            System.out.println(0);
            return;
        }
        while (true){
            if(sum>=s){
                length = Math.min(length,end-start);
                sum-=arr[start];
                start++;
            }else if(end==n){
                break;
            }else {
                sum+=arr[end++];
            }
        }
        System.out.println(length);

    }
}
