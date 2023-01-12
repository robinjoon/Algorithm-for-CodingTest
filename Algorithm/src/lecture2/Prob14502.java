package lecture2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prob14502 {
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {-1,0,1,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        List<int[]> canWall = new ArrayList<>();
        int wallCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j]==0)canWall.add(new int[]{i,j});
                else if(arr[i][j]==1)wallCount++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < canWall.size(); i++) {
            for (int j = 0; j < canWall.size(); j++) {
                if(i==j)continue;
                for (int k = 0; k < canWall.size(); k++) {
                    if(i==k || j == k) continue;
                    int[] f = canWall.get(i);
                    int[] s = canWall.get(j);
                    int[] t = canWall.get(k);
                    int[][] tmp = buildWall(arr,f,s,t,n,m);
                    int size = 0;
                    boolean[][] visited = new boolean[n][m];
                    for (int l = 0; l < n; l++) {
                        for (int o = 0; o < m; o++) {
                            if(tmp[l][o]==2 && !visited[l][o])size+=dfs(tmp,visited,l,o);
                        }
                    }
                    min = Math.min(min,size);
                }
            }
        }
        System.out.println(n * m - min - 3 - wallCount);

    }
    private static int dfs(int[][] arr, boolean[][] visited, int x,int y){
        if(!visited[x][y] && arr[x][y] != 1){
            visited[x][y] = true;
            int sum = 1;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx< arr.length && ny>=0 && ny<arr[0].length){
                    sum+=dfs(arr,visited,nx,ny);
                }
            }
            return sum;
        }
        return 0;
    }
    private static int[][] buildWall(int[][] arr, int[] f,int[] s,int[] t, int n, int m){
        int[][] tmp = new int[n][m];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = arr[i][j];
                if(f[0]==i && f[1]==j){
                    tmp[i][j]=1;
                }
                if(s[0]==i && s[1]==j){
                    tmp[i][j]=1;
                }
                if(t[0]==i && t[1]==j){
                    tmp[i][j]=1;
                }
            }
        }
        return tmp;
    }
}
