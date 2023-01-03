package lecture2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob2583_intDfs {
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
        boolean[][] visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j]!=-1){
                    list.add(dfs(map,visited,i,j));
                }
            }
        }
        System.out.println(list.size());
        list.stream().sorted().forEach(i->System.out.print(i+" "));
    }
    private static int dfs(int[][] map, boolean[][] visited, int x,int y){
        int ret = 1;
        if(!visited[x][y]){
            visited[x][y]=true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length && map[nx][ny]!=-1){
                    ret+=dfs(map,visited,nx,ny);
                }
            }
            return ret;
        }
        return 0;
    }
}
