package prefixsum.backjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prob13900 {
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
            sum[i] = sum[i-1]+arr[i];
        }
        long answer = 0;
        for (int i = 1; i < n-1; i++) {
            answer = answer + arr[i] *(pSum(sum,0,i-1) + pSum(sum,i+1,n-1));
        }
        answer+=arr[0]*pSum(sum,1,n-1);
        answer+=arr[n-1]*pSum(sum,0,n-2);
        System.out.println(answer/2);
    }
    private static long pSum(long[] sum,int l,int r){
        if(l>0){
            return sum[r]-sum[l-1];
        }else {
            return sum[r];
        }
    }
}
