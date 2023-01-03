package lecture2;

import java.util.*;

public class Prob2910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextInt();
        Map<Integer,Integer> freqs = new HashMap<>(); // 숫자 - 빈도
        Map<Integer,Integer> index = new HashMap<>(); // 숫자 - 첫 등장 위치
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if(freqs.containsKey(num)){
                freqs.put(num, freqs.get(num)+1);
            }else {
                index.put(num,i);
                freqs.put(num,1);
            }
        }
        Map<Integer,List<Integer>> freqNums = new HashMap<>(); // 빈도 - 숫자들
        for (int num: freqs.keySet()) {
            int freq = freqs.get(num);
            if(freqNums.containsKey(freq)){
                freqNums.get(freq).add(num);
            }else {
                List<Integer> nums = new ArrayList<>();
                nums.add(num);
                freqNums.put(freq,nums);
            }
        }
        for (List<Integer> nums: freqNums.values()) {
            Collections.sort(nums, Comparator.comparingInt(index::get));
        }
        freqNums.keySet().stream().sorted(Comparator.reverseOrder()).forEach(key->{
            List<Integer> list = freqNums.get(key);
            list.forEach(e->{
                int count = freqs.get(e);
                for (int i = 0; i < count; i++) {
                    System.out.print(e+" ");
                }
            });
        });
    }
}
