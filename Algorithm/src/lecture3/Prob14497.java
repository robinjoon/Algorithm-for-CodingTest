package lecture3;

import java.util.*;

public class Prob14497 {
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {-1,0,1,0};
    private static int count = 0;
    private static boolean flag =false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }
        map[x1-1][y1-1]='0';
        while (true) {
            count++;
            if(flag)break;
            dfs(map, x1 - 1, y1 - 1, new boolean[n][m]);
            change(map,n,m);
        }
    }
    private static void change(char[][] map,int n,int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '2')
                    map[i][j] = '0';
            }
        }
    }
    private static void dfs(char[][] map,int x,int y,boolean[][] visited){
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length && !visited[nx][ny]){
                if(map[nx][ny]=='1'){
                    map[nx][ny]='2';
                    visited[nx][ny] = true;
                }else if (map[nx][ny]=='0') {
                    dfs(map,nx,ny,visited);
                }else{
                    if(flag)return;
                    System.out.println(count);
                    flag = true;
                    return;
                }
            }
        }
    }

}
