package lecture2;

import java.util.Arrays;
import java.util.Scanner;

public class Prob2636 {
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {-1,0,1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        while (true){
            dfs(arr,new boolean[n][m],0,0);
            count++;
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j]==1){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (arr[i][j] == 2) arr[i][j] = 0;
                    }
                }
            }else {
                System.out.println(count);
                int lastCheese = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (arr[i][j] == 2) lastCheese++;
                    }
                }
                System.out.println(lastCheese);
                return;
            }

        }
    }
    private static void dfs(int[][] arr,boolean[][] visited,int x,int y){
        if(!visited[x][y]){
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<arr.length && ny>=0 && ny< arr[0].length){
                    if(arr[nx][ny]==1){
                        arr[nx][ny] = 2;
                        visited[nx][ny] = true;
                    }else{
                        dfs(arr,visited,nx,ny);
                    }
                }
            }
        }
    }
}
