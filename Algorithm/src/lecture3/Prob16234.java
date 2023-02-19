package lecture3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Prob16234 {
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {-1,0,1,0};
    private static int n,l,r;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        int[][] arr =new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        int[][] visited = new int[n][n];
        int group = 1;
        List<Integer> valueList = new ArrayList<>();
        while (true){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j]==0){
                        int[] sum = dfs(arr,visited,i,j,group);
                        valueList.add(sum[0]/sum[1]);
                        group++;
                    }
                }
            }
            if(valueList.size()==n*n)break;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = valueList.get(visited[i][j]-1);
                }
            }
            count++;
            visited = new int[n][n];
            valueList.clear();
            group=1;
        }
        System.out.println(count);
    }
    private static int[] dfs(int[][] map,int[][] visited, int x,int y,int group){
        if(visited[x][y]!=0){
            return new int[]{0,0};
        }
        visited[x][y] = group;
        int[] ret = new int[]{0,0};
        ret[0]=map[x][y];
        ret[1]=1;
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<n&&nx>=0&&ny<n&&ny>=0&& Math.abs(map[x][y]-map[nx][ny])>=l && Math.abs(map[x][y]-map[nx][ny])<=r && visited[nx][ny]==0){
                int[] arr = dfs(map,visited,nx,ny,group);
                ret[0]+=arr[0];
                ret[1]+=arr[1];
            }
        }
        return ret;
    }
}
