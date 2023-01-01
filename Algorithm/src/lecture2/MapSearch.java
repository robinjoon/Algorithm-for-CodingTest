package lecture2;

import java.util.LinkedList;
import java.util.Queue;

public class MapSearch {
    public static void main(String[] args) {
        int[][] map = new int[][]{
            {1,0,1},
            {1,1,0},
            {0,1,1}
        };
        int[] dx = new int[]{0,1,0,-1};
        int[] dy = new int[]{1,0,-1,0};
        boolean[][] visited = new boolean[3][3];
        visited[0][0] = true;
        int x = 0,y=0;
        Queue<int[]> queue = new LinkedList<>();
        while (true){
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(!canGo(nx,ny)){
                    continue;
                }
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny});
                    System.out.println(nx+","+ny);
                }
            }
            if(!queue.isEmpty()) {
                int[] next = queue.poll();
                x = next[0];
                y = next[1];
            }else {
                break;
            }
        }
    }
    private static boolean canGo(int x,int y){
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }
}
