package lecture3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
최단 거리 = bfs, visited[next] = visited[now] + 1
if(visited[next]==0){
    visited[next] = visited[now]+1;
    count[next] = count[now];
    q.add(next);
}else if(visited[next]==visited[now]+1){
    count[next] += count[now]; 다음 노드의 경로로 가는 개수 는 이전 노드의 그것의 합
}
 */

public class Prob12851 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        if(n==k){
            System.out.println(0);
            System.out.println(0);
            return;
        }
        bfs(n,k);
    }
    private static void bfs(int n,int k){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int[] visited = new int[300000];
        int[] count = new int[300000];
        visited[n]=1;
        count[n]=1;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int next : new int[]{now-1,now+1,now*2}){
                if(next<0 || next>200000){
                    continue;
                }
                if(visited[next]==0){
                    visited[next] = visited[now]+1;
                    count[next] = count[now];
                    q.add(next);
                }else if(visited[next]==visited[now]+1){
                    count[next] += count[now];
                }
            }
        }
        System.out.println(visited[k]-1);
        System.out.println(count[k]);
    }
}
