package lecture2;

import java.util.Arrays;
import java.util.Scanner;

public class Prob10709 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr =new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] chars = sc.next().toCharArray();
            System.arraycopy(chars, 0, arr[i], 0, m);
        }
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = 0;
                boolean flag = true;
                for (int k = j; k >=0; k--) {
                    if(arr[i][k]=='c') {
                        result[i][j] = count;
                        flag = false;
                        break;
                    }else count++;
                }
                if(flag){
                    result[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
