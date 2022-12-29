package lecture1;

import java.util.Scanner;
import java.util.Stack;

public class Prob3986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (char ch:str.toCharArray()) {
                if(!stack.isEmpty() && stack.peek() == ch)stack.pop();
                else stack.push(ch);
            }
            if(stack.isEmpty()){
                count++;
            }
            stack.clear();
        }
        System.out.println(count);
    }
}
