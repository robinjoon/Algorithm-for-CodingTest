package lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Prob2468 {
    private static int[] dx = new int[]{0,1,0,-1};
    private static int[] dy = new int[]{-1,0,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][n];
        int max = 0;
        for (int i = 0; i <n; i++) {
            String str = reader.readLine();
            String[] strs = str.split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(strs[j]);
                max = Math.max(max,map[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < max; i++) {
            result = Math.max(result,getSafeAreaCount(map,i));
        }
        System.out.println(result);
    }
    private static int getSafeAreaCount(int[][] map, int rain){
        boolean[][] visited = new boolean[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] -=rain;
            }
        }
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if(!visited[i][j] && map[i][j]>0){
                    dfs(map,i,j,visited,rain);
                    count++;
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] +=rain;
            }
        }
        return count;
    }
    private static void dfs(int[][] map, int x, int y, boolean[][] visited, int rain){
        if(!visited[x][y] && map[x][y]>0){
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length && map[nx][ny]>0){
                    dfs(map,nx,ny,visited,rain);
                }
            }
        }
    }
}
