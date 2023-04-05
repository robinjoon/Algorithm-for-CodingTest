package lecture3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob9934 {
    private static List<List<Integer>> out = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        List<Integer> list = new ArrayList<>();
        String[] strings = str.split(" ");
        for (String string : strings) {
            list.add(Integer.parseInt(string));
        }
        for (int i = 0; i < n; i++) {
            out.add(new ArrayList<>());
        }
        dfs(list,0, list.size()-1,0);
        StringBuilder sb = new StringBuilder();
        for (List<Integer> integers : out) {
            for (Integer integer : integers) {
                sb.append(integer).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    private static void dfs(List<Integer> list,int start,int end,int level){
        if(start == end){
            out.get(level).add(list.get(start));
            return;
        }
        int middle = (start + end)/2;
        out.get(level).add(list.get(middle));
        dfs(list,start,middle-1,level+1);
        dfs(list,middle+1,end,level+1);
    }
}
