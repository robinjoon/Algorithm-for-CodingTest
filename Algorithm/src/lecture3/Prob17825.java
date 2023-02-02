package lecture3;

import java.util.*;

public class Prob17825 {
    private static Map<Integer,List<Integer>> map = new HashMap<>();
    private static int[] points = {
            0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,0,13,16,19,25,26,27,28,22,24,30,35
    };
    private static int answer = 0;
    private static int[] horse = new int[4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        makeMap();
        int[] num = new int[10];
        for (int i = 0; i < 10; i++) {
            num[i]=sc.nextInt();
        }
        go(0,0,num);
        System.out.println(answer);
    }
    private static void go(int nowPoint,int turn,int[] num){
        for (int i = 0; i < 4; i++) {
            if(!canMove(i,num[turn]))continue;
            int saveIndex = horse[i];
            int tmpIndex = move(i,num[turn]);
            int tmpPoint = nowPoint + points[tmpIndex];
            if(turn==9){
                answer = Math.max(answer,tmpPoint);
            }else{
                go(tmpPoint,turn+1,num);
            }
            horse[i] =saveIndex;
        }
    }
    private static boolean canMove(int index,int value){
        if(horse[index]==21)return false;
        List<Integer> adj = map.get(horse[index]);
        int nowIndex = horse[index];
        if(adj.size()>1){
            nowIndex = adj.get(1);
        }else {
            nowIndex = adj.get(0);
        }
        for (int i = 0; i < value-1; i++) {
            if(nowIndex == 21)return true;
            nowIndex = map.get(nowIndex).get(0);
        }
        for (int i = 0; i < 4; i++) {
            if(horse[i]==nowIndex){
                if(nowIndex != 21){
                    return false;
                }
            }
        }
        return true;
    }
    private static int move(int index,int value){
        List<Integer> adj = map.get(horse[index]);
        int nowIndex = horse[index];
        if(adj.size()>1){
            nowIndex = adj.get(1);
        }else {
            nowIndex = adj.get(0);
        }
        for (int i = 0; i < value-1; i++) {
            if(nowIndex==21)break;
            nowIndex = map.get(nowIndex).get(0);
        }
        horse[index] = nowIndex;
        return nowIndex;
    }
    private static void makeMap(){
        for (int i = 0; i < 21; i++) {
            List<Integer> adj = new ArrayList<>();
            adj.add(i+1);
            map.put(i,adj);
        }
        List<Integer> adj5 = map.get(5);
        adj5.add(22);
        for (int i = 22; i <= 24; i++) {
            List<Integer> adj = new ArrayList<>();
            adj.add(i+1);
            map.put(i,adj);
        }
        map.get(15).add(28);
        List<Integer> adj28 = new ArrayList<>();
        adj28.add(27);
        map.put(28,adj28);
        List<Integer> adj27 = new ArrayList<>();
        adj27.add(26);
        map.put(27,adj27);
        List<Integer> adj26 = new ArrayList<>();
        adj26.add(25);
        map.put(26,adj26);
        map.get(10).add(29);
        List<Integer> adj29 = new ArrayList<>();
        adj29.add(30);
        map.put(29,adj29);
        List<Integer> adj30 = new ArrayList<>();
        adj30.add(25);
        map.put(30,adj30);
        List<Integer> adj25 = new ArrayList<>();
        adj25.add(31);
        map.put(25,adj25);
        List<Integer> adj31 = new ArrayList<>();
        adj31.add(32);
        map.put(31,adj31);
        List<Integer> adj32 = new ArrayList<>();
        adj32.add(20);
        map.put(32,adj32);
    }
}
