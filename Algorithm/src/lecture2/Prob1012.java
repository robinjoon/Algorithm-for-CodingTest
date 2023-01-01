package lecture2;

import java.util.*;

public class Prob1012 {
    private static int[] dx = new int[]{0,1,0,-1};
    private static int[] dy = new int[]{-1,0,1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] map = new int[m][n];
            int[][] visited = new int[m][n];
            List<int[]> list = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
                list.add(new int[]{x,y});
            }
            int count =0;
            for (int[] v:list) {
                if(visited[v[0]][v[1]]==0){
                    dfs(map,v,visited);
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    private static void dfs(int[][] map, int[] here,int[][] visited){
        if(visited[here[0]][here[1]]==0){
            visited[here[0]][here[1]] = 1;
            int x = here[0],y = here[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y +dy[i];
                if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length && map[nx][ny]==1){
                    dfs(map,new int[]{nx,ny},visited);
                }
            }
        }
    }
}
