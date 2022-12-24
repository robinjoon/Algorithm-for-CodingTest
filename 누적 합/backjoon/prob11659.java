package prefixsum.backjoon;

import java.util.Scanner;

public class prob11659 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] sum = new int[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1]+arr[i];
        }
        for (int i = 0; i < m; i++) {
            System.out.println(pSum(scanner.nextInt()-1,scanner.nextInt()-1,sum));
        }
    }
    private static int pSum(int l,int r, int[] sum){
        if(l>0)
            return sum[r]-sum[l-1];
        else
            return sum[r];
    }
}
