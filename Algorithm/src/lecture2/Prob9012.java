package lecture2;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Prob9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char[] chars = sc.next().toCharArray();
            try {
                for (char c: chars) {
                    if(c=='(')stack.push(c);
                    else stack.pop();
                }
            }catch (EmptyStackException e){
                System.out.println("NO");
                continue;
            }
            if(!stack.empty())System.out.println("NO");
            else System.out.println("YES");
            stack.clear();
        }
    }
}
