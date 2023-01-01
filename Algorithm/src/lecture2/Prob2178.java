package lecture2;

import java.util.*;

public class Prob2178 {
    private static int[] dx = new int[]{0,1,0,-1};
    private static int[] dy = new int[]{-1,0,1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            char[] inputChars = input.toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = inputChars[j]=='1'?1:0;
            }
        }
        int[][] visited = new int[n][m];
        bfs(map,new int[]{0,0},visited);
        System.out.println(visited[n-1][m-1]);
    }
    static void bfs(int[][] map, int[] here, int[][] visited){
        if(visited[here[0]][here[1]]==0){
            Queue<int[]> queue = new LinkedList<>();
            visited[here[0]][here[1]] = 1;
            queue.add(here);
            while (!queue.isEmpty()){
                int[] now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now[0]+dx[i];
                    int ny = now[1]+dy[i];
                    if(nx>=0 && nx<map.length && ny>=0 && ny<map[0].length && map[nx][ny]==1){
                        if(visited[nx][ny]==0){
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.add(new int[]{nx,ny});
                        }
                    }
                }
            }
        }
    }
}
