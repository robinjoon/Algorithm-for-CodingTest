package lecture2;

import java.util.*;

public class Prob2910_sortOnce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextInt();
        Map<Integer,Integer> numFreq = new HashMap<>();
        Map<Integer,Integer> numFirstIndex = new HashMap<>();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            nums.add(num);
            if(numFreq.containsKey(num)){
                numFreq.put(num,numFreq.get(num)+1);
            }else {
                numFreq.put(num,1);
                numFirstIndex.put(num,i);
            }
        }
        nums.sort((o1, o2) -> {
            if (numFreq.get(o1).equals(numFreq.get(o2))) {
                return numFirstIndex.get(o1) - numFirstIndex.get(o2);
            } else {
                return numFreq.get(o2) - numFreq.get(o1);
            }
        });
        nums.forEach(e->System.out.print(e+" "));
    }
}
