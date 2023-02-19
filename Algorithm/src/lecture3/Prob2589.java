package lecture3;

import java.util.*;

public class Prob2589 {
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {-1,0,1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] chs = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = chs[j];
            }
        }
        int[][] visited = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]=='L') {
                    max = Math.max(bfs(arr, visited, i, j), max);
                    visited = new int[n][m];
                }
            }
        }
        System.out.println(max-1);
    }
    private static int bfs(char[][] arr,int[][] visited,int x,int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y]=1;
        while (!queue.isEmpty()){
            int[] node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node[0]+dx[i];
                int ny = node[1]+dy[i];
                if( nx>=0 && nx< arr.length && ny>=0 && ny<arr[0].length&&arr[nx][ny]=='L' && visited[nx][ny]==0){
                    queue.add(new int[]{nx,ny});
                    visited[nx][ny] = visited[node[0]][node[1]]+1;
                }
            }
        }
        int max = 0;
        for (int[] ints : visited) {
            for (int anInt : ints) {
                max = Math.max(max, anInt);
            }
        }
        return max;
    }
}
