package lecture4;

import java.util.Scanner;

public class Prob14890 {
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] map = new int[n][n];
        int[][] map2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                map2[j][i] = map[i][j];
            }
        }
        solve(map,n,l);
        solve(map2,n,l);
        System.out.println(result);
    }
    private static void solve(int[][] map, int n,int l){
        for (int i = 0; i < n; i++) {
            int count = 1;
            int j;
            for (j = 0; j < n-1; j++) {
                if(map[i][j] == map[i][j+1]){
                    count++;
                }else if(map[i][j]+1 == map[i][j+1] && count>=l){
                    count = 1;
                }else if(map[i][j]-1 == map[i][j+1] && count>=0){
                    count = -l + 1;
                }else{
                    break;
                }
            }
            if(j == n-1 && count>=0){
                result++;
            }
        }
    }
}
