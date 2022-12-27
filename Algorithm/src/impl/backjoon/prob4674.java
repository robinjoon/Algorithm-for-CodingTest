package impl.backjoon;

import java.util.Arrays;

public class prob4674 {
    public static void main(String[] args) {
        int[] arr = new int[10001];
        for (int i = 1; i < 10001; i++) {
            arr[i] = d(i);
        }
        Arrays.sort(arr);
        for (int i = 1; i < 10001; i++) {
            if(Arrays.binarySearch(arr,i)<-1){
                System.out.println(i);
            }
        }
    }
    private static int d(int n){
        int result = n;
        while (n>0){
            result+=n%10;
            n = n /10;
        }
        return result;
    }
}
