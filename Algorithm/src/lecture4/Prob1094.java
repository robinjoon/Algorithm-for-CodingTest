package lecture4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Prob1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(64);
        int sum = 64;
        while (sum !=x){
            if(sum>x){
                Collections.sort(list);
                int removed = list.remove(0);
                list.add(0,removed/2);
                list.add(0,removed/2);
                if(sum - removed/2 >=x){
                    list.remove(0);
                    sum = sum - removed/2;
                }
            }
        }
        System.out.println(list.size());
    }
}
