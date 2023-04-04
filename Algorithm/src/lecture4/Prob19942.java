package lecture4;

import java.util.*;

public class Prob19942 {
    public static void main(String[] args) {
        class Food{
            int dan,tan,zi,bi,p;
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] minLevel = new int[4];
        for (int i = 0; i < 4; i++) {
            minLevel[i] = scanner.nextInt();
        }
        Food[] foods = new Food[n+1];
        for (int i = 0; i < n; i++) {
            Food food = new Food();
            food.dan = scanner.nextInt();
            food.zi = scanner.nextInt();
            food.tan = scanner.nextInt();
            food.bi = scanner.nextInt();
            food.p = scanner.nextInt();
            foods[i] = food;
        }
        int bitMask = 1;
        int min = Integer.MAX_VALUE;
        List<Integer> minBitMasks = new ArrayList<>();
        int sum[] = new int[]{0,0,0,0,0};
        while (bitMask <= (1<<n)-1){
            for (int i = 0; i < n; i++) {
                if((bitMask & (1<<i))==(1 << i)){
                    sum[0] += foods[i].dan;
                    sum[1] += foods[i].zi;
                    sum[2] += foods[i].tan;
                    sum[3] += foods[i].bi;
                    sum[4] += foods[i].p;
                }
            }
            if(sum[0]>=minLevel[0] && sum[1]>=minLevel[1] && sum[2]>=minLevel[2] && sum[3]>=minLevel[3]){
                if(min > sum[4]){
                    min = sum[4];
                    minBitMasks.clear();
                    minBitMasks.add(bitMask);
                }else if(min == sum[4]){
                    minBitMasks.add(bitMask);
                }
            }
            sum = new int[]{0,0,0,0,0};
            bitMask++;
        }
        minBitMasks.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                List<Integer> l1 = new ArrayList<>();
                List<Integer> l2 = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if ((o1 & (1 << i)) == (1 << i)) {
                        l1.add(i + 1);
                    }
                    if ((o2 & (1 << i)) == (1 << i)) {
                        l2.add(i + 1);
                    }
                }
                int size = Math.min(l1.size(), l2.size());
                for (int i = 0; i < size; i++) {
                    if (!Objects.equals(l1.get(i), l2.get(i))){
                        return l1.get(i)-l2.get(i);
                    }
                }
                return l1.size() - l2.size();
            }
        });
        if(min != Integer.MAX_VALUE){
            System.out.println(min);
            for (int i = 0; i < n; i++) {
                if((minBitMasks.get(0) & (1<<i))==(1 << i)){
                    System.out.print(i+1+" ");
                }
            }
        }else{
            System.out.println(-1);
        }
    }
}
