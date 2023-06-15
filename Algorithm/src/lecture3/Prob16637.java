package lecture3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob16637 {
    private static List<String> list = new ArrayList<>();
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        for (char ch:input.toCharArray()) {
            list.add(ch+"");
        }
        dfs(1,Integer.parseInt(list.get(0)));
        System.out.println(max);
    }
    private static int calc(String a,String b,String op){
        if(op.equals("+"))return Integer.parseInt(a)+Integer.parseInt(b);
        if(op.equals("-"))return Integer.parseInt(a)-Integer.parseInt(b);
        if(op.equals("*"))return Integer.parseInt(a)*Integer.parseInt(b);
        return Integer.parseInt(a)/Integer.parseInt(b);
    }
    //최초 opIndex = 1
    private static void dfs(int opIndex,int before){
        if(opIndex>list.size()-1){
            max = Math.max(max,before);
            return;
        }
        if(opIndex+3<list.size()) {
            // 괄호
            int next = calc(list.get(opIndex + 1), list.get(opIndex + 3), list.get(opIndex + 2));
            int result = calc(before + "", next + "", list.get(opIndex));
            dfs(opIndex + 4, result);
        }
        // 괄호 X
        int result = calc(before+"",list.get(opIndex+1),list.get(opIndex));
        dfs(opIndex+2,result);
    }
}
