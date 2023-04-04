package lecture4;

import java.util.*;

public class Prob17471 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> nodes = new ArrayList<>();
        nodes.add(null);
        for (int i = 1; i < n+1; i++) {
            int size = sc.nextInt();
            nodes.add(new Node(i,size));
        }
        List<List<Node>> map = new ArrayList<>();
        map.add(Collections.emptyList());
        for (int i = 1; i < n+1; i++) {
            int m = sc.nextInt();
            List<Node> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(nodes.get(sc.nextInt()));
            }
            map.add(list);
        }
        int mask = 1;
        int min = Integer.MAX_VALUE;
        go :while (mask < (1<<n)-1){
            int size1 = 0;
            int size2 = 0;
            List<Integer> g1 = new ArrayList<>();
            List<Integer> g2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if((mask & (1<<i))==(1 << i)){
                    g1.add(i+1);
                    size1 += nodes.get(i+1).size;
                }else {
                    g2.add(i+1);
                    size2 += nodes.get(i+1).size;
                }
            }
            boolean[] visited = new boolean[n+1];
            dfs(map,visited,g1.get(0),g1);
            for (int g:g1) {
                if(!visited[g]){
                    mask++;
                    continue go;
                }
            }
            visited = new boolean[n+1];
            dfs(map,visited,g2.get(0),g2);
            for (int g:g2) {
                if(!visited[g]){
                    mask++;
                    continue go;
                }
            }
            min = Math.min(min,Math.abs(size1-size2));
            mask++;
        }
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }
    private static void dfs(List<List<Node>> map,boolean[] visited,int now,List<Integer> group){
        if(!visited[now]){
            visited[now] = true;
            for (Node node:map.get(now)) {
                if(group.contains(node.num)) {
                    dfs(map, visited, node.num, group);
                }
            }
        }
    }
    static class Node{
        int num;
        int size;
        public Node(int num, int size) {
            this.num = num;
            this.size = size;
        }
    }
}
