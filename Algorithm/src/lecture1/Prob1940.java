package lecture1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prob1940 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m =scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num:arr) {
            if(set.contains(num))count++;
            else {
                set.add(m-num);
            }
        }
        System.out.println(count);
    }
}
