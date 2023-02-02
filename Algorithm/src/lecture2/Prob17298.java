package lecture2;

import java.util.*;

public class Prob17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Map<Integer,Integer> answer = new HashMap<>();
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty()&&arr[i]>arr[stack.peek()]){
                answer.put(stack.pop(),i);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            answer.put(stack.pop(),-1);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if(answer.get(i)==-1)sb.append("-1 ");
            else sb.append(arr[answer.get(i)]).append(" ");
        }
        System.out.print(sb);
    }
}
