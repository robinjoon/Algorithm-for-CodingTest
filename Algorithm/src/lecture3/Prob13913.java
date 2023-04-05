package lecture3;

import java.util.*;

public class Prob13913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < 2000004; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
        }
        bfs(n,k);
    }
    private static void bfs(int n,int k){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int[] visited = new int[200004];
        int[] parent = new int[200004];
        visited[n] = 1;
        while (!queue.isEmpty()){
            int now = queue.poll();
            for (int next: new int[]{now-1,now+1,now*2}) {
                if(next<0 || next>200000){
                    continue;
                }
                if(visited[next]==0){
                    visited[next] = visited[now] + 1;
                    parent[next] = now;
                    queue.add(next);
                }
            }
        }
        System.out.println(visited[k]-1);
        int a = k;
        List<Integer> list = new ArrayList<>();
        list.add(a);
        for (int i = 0; i < visited[k]-1; i++) {
            list.add(parent[a]);
            a = parent[a];
        }
        Collections.reverse(list);
        list.forEach(i->System.out.print(i+" "));
    }
}
