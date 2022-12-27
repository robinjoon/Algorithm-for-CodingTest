package prefixsum.backjoon;

import java.util.Scanner;

public class Prob21921 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n+1];
        arr[0]=0;
        for (int i = 1; i < n+1; i++) {
            arr[i] = arr[i-1]+scanner.nextInt();
        }
        int max =0;
        int count = 0;
        for (int i = x; i < n+1; i++) {
            int psum = arr[i]-arr[i-x];
            if(psum>max){
                count =1;
                max = psum;
            }else if(psum == max){
                    count++;
            }
        }
        if(max==0){
            System.out.println("SAD");
        }else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
