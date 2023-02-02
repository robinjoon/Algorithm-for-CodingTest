package lecture3;

import java.util.*;

public class Prob15686 {
    static List<List<Integer>> list = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();
    static List<List<Integer>> combi = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][n];
        int chickenCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j]==2){
                    chickenCount++;
                    chickens.add(new int[]{i,j});
                } else if (map[i][j]==1) {
                    house.add(new int[]{i,j});
                }
            }
        }
        int[] makeCombi = new int[chickenCount];
        for (int i = 0; i < makeCombi.length; i++) {
            makeCombi[i]=i;
        }
        comb2(makeCombi,new boolean[chickenCount],0,m);
        int answer = Integer.MAX_VALUE;
        for (List<Integer> c:combi) {
            int[] cl = new int[house.size()];
            Arrays.fill(cl,Integer.MAX_VALUE);
            for (int index:c) {
                int[] chicken = chickens.get(index);
                for (int i = 0; i < house.size(); i++) {
                    int[] home = house.get(i);
                    cl[i] = Math.min(cl[i],Math.abs(home[0]-chicken[0])+Math.abs(home[1]-chicken[1]));
                }
            }
            answer = Math.min(answer, Arrays.stream(cl).sum());
        }
        System.out.println(answer);
    }
    static void comb2(int[] arr, boolean[] visited, int depth, int r) {
        if(r == 0) {
            print(arr, visited);
            return;
        }
        if(depth == arr.length) {
            return;
        } else {
            visited[depth] = true;
            comb2(arr, visited, depth + 1, r - 1);

            visited[depth] = false;
            comb2(arr, visited, depth + 1, r);
        }
    }
    static void print(int[] arr, boolean[] visited) {
        List<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(visited[i])
                tmp.add(arr[i]);
        }
        combi.add(tmp);
    }
}
