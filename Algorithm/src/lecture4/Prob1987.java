package lecture4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prob1987 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int answer =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            map[i] = str.toCharArray();
        }
        dfs(map,new boolean[n][m],0,0,new HashSet<>());
        System.out.println(answer);
    }
    private static void dfs(char[][] map,boolean[][] visited,int x,int y,Set<Character> set){
        if(!visited[x][y]){
            visited[x][y]=true;
            set.add(map[x][y]);
            answer = Math.max(answer,set.size());
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length && !set.contains(map[nx][ny])){
                    dfs(map,visited,nx,ny,set);
                    visited[nx][ny] = false;
                    set.remove(map[nx][ny]);
                }
            }
        }
    }
}
