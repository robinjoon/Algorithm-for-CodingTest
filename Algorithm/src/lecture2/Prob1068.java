package lecture2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob1068 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]==-1){
                root = i;
                continue;
            }
            tree.get(arr[i]).add(i);
        }
        int erased = sc.nextInt();
        if(root == erased){
            System.out.println(0);
            return;
        }else {
            tree.get(erased).clear();
        }
        System.out.println(dfs(tree,root,erased));
    }
    private static int dfs(List<List<Integer>> tree, int root,int erased){
        List<Integer> list = tree.get(root);
        int sum = 0;
        for (int num:list) {
            if(num!=erased){
                if(tree.get(num).isEmpty() || (tree.get(num).size()==1 && tree.get(num).get(0)==erased)){
                    sum++;
                }else {
                    sum+=dfs(tree,num,erased);
                }
            }
        }
        if(list.size()==1 && list.get(0)==erased)sum++;
        return sum;
    }
}
