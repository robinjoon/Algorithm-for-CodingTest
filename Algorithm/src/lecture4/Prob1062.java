package lecture4;

import java.util.*;

public class Prob1062 {
    static boolean[] visited = new boolean[26];
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.next().replace("anta","").replace("tica",""));
        }
        if(k<5){
            System.out.println(0);
            return;
        }
        if(n==26){
            System.out.println(n);
            return;
        }
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        dfs(0,0,k,list);
        System.out.println(max);
    }
    static void dfs(int alpha,int size,int limit,List<String> strings){
        if(size == limit -5){
            int count = 0;
            for (String string : strings) {
                boolean flag  = true;
                for (char c : string.toCharArray()) {
                    if(!visited[c-'a']){
                        flag = false;
                        break;
                    }
                }
                if(flag)count++;
            }
            max = Math.max(max,count);
        }
        for (int i = alpha; i < 26; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i,size + 1, limit, strings);
                visited[i] = false;
            }
        }
    }
}
