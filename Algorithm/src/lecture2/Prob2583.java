package lecture2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class Prob2583 {
    private static int[] dx = new int[]{0,1,0,-1};
    private static int[] dy = new int[]{-1,0,1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[n][m];
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int x1 = sc.nextInt(),y1 = sc.nextInt();
            int x2 = sc.nextInt(),y2 = sc.nextInt();
            for (int j = x1; j <x2; j++) {
                for (int l = y1; l <y2; l++) {
                    map[j][l] = -1;
                }
            }
        }
        int count = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j]!=-1){
                    dfs(map,visited,i,j,count);
                    count++;
                }
            }
        }
        int[] size = new int[count];
        System.out.println(count);
        for (int j = 0; j < map.length; j++) {
            for (int l = 0; l < map[j].length; l++) {
                if(map[j][l]!=-1) size[map[j][l]]++;
            }
        }
        Arrays.stream(size).sorted().forEach(i->System.out.print(i+" "));
    }
    private static void dfs(int[][] map, boolean[][] visited,int x,int y, int color){
        if(!visited[x][y]){
            visited[x][y] =true;
            map[x][y] = color;
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length && map[nx][ny]!=-1){
                    dfs(map,visited,nx,ny,color);
                }
            }
        }
    }
}
