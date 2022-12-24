package prefixsum.backjoon;

import java.util.Scanner;

public class prob2167 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] arr = new int[n+1][m+1];
        int[][] sum = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        sum[0][0] = arr[0][0];
        for (int i = 1; i < n+1; i++) {
            sum[i][1] = arr[i][1];
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 2; j < m+1; j++) {
                sum[i][j] = sum[i][j-1]+arr[i][j];
            }
        }
        for (int i = 2; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                sum[i][j] += sum[i-1][j];
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            stringBuffer.append(getPsum(x1,y1,x2,y2,sum)).append("\n");
        }
        System.out.println(stringBuffer.toString());
    }
    public static int getPsum(int x1,int y1,int x2,int y2,int[][] sum){
        return sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] +  sum[x1-1][y1-1];
    }
}
