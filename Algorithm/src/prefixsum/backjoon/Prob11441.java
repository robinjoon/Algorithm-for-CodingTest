package prefixsum.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Prob11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n+1];
        String input = reader.readLine();
        String[] nums = input.split(" ");
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(nums[i-1]);
        }
        for (int i = 1; i < n+1; i++) {
            arr[i]+=arr[i-1];
        }
        int m = Integer.parseInt(reader.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            String str = reader.readLine();
            String[] strs = str.split(" ");
            int l = Integer.parseInt(strs[0]);
            int r = Integer.parseInt(strs[1]);
            sb.append(arr[r]-arr[l-1]).append("\n");
        }
        System.out.print(sb);
    }
}
