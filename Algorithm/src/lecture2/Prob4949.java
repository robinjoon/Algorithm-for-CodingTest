package lecture2;

import java.util.Scanner;
import java.util.Stack;

public class Prob4949 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (true){
            String str = sc.nextLine();
            if(str.equals("."))break;
            System.out.println(solve(str));
        }
    }
    private static String solve(String str){
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if(c == '(' || c == '['){
                stack.push(c);
            }
            if(c == ')'){
                if(stack.empty() || stack.pop()!='(')return "no";
            }
            if(c == ']'){
                if(stack.empty() || stack.pop()!='[')return "no";
            }
        }
        if(stack.empty()) return "yes";
        else return "no";
    }
}
