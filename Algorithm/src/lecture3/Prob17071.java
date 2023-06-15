package lecture3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Prob17071 {
    private static int min = Integer.MAX_VALUE;
    private static int[][] visited = new int[2][500001];
    // v[0][i] = i번째 칸을 처음 방문한 짝수 시간 => t 일때 동생이 i칸에 있다면, v[0][i]와 t 의 차가 2의 배수라면 t일때 수빈도 i에 있음. = t가 답
    // v[1][i] = i번째 칸을 처음 방문한 홀수 시간
    public static void main(String[] args) {
        Arrays.fill(visited[0],-1);
        Arrays.fill(visited[1],-1);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        bfs(n,k);
        for (int time = 0;; time++) {
            int bro = k + time*(time+1)/2; // time에 동생 위치
            if(bro>500000){
                System.out.println(-1);
                return;
            }
            int firstVisitTime = visited[time%2][bro];
            if(firstVisitTime<=time && (time-firstVisitTime)%2==0){
                System.out.println(time);
                return;
            }
        }
    }
    private static void bfs(int start,long target){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start,0});
        visited[0][start] = 0;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int nextP : new int[]{now[0]-1,now[0]+1,now[0]*2}){
                int[] next = new int[]{nextP,now[1]+1};
                if(nextP>500000 || nextP<0)continue;
                if(visited[next[1]%2][nextP]!=-1)continue;
                visited[next[1]%2][nextP] = next[1]; // 수빈이 nextP 를 처음 방문한 시간
                queue.add(next);
            }
        }
    }
}
