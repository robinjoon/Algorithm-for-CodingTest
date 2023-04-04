package lecture4;
import java.util.*;
/*
행을 뒤집고, 열을 확인한다.
 */
public class Prob1285 {
    public static void main(String[] args) {
        List<List<Boolean>> map = new ArrayList<>();
        List<List<Boolean>> back = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            char[] line = sc.next().toCharArray();
            List<Boolean> list = new ArrayList<>();
            for (char c : line) {
                if(c=='T')list.add(false);
                else list.add(true);
            }
            map.add(list);
        }
        for (int i = 0; i < n; i++) {
            List<Boolean> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(map.get(i).get(j));
            }
            back.add(list);
        }
        int mask = 0;
        int min = Integer.MAX_VALUE;
        while (mask < (1<<n)-1){
            for (int i = 0; i < n; i++) {
                if((mask & (1<<i))==(1 << i)){
                    for (int j = 0; j < n; j++) {
                        map.get(i).set(j,!map.get(i).get(j));
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if(map.get(j).get(i)){
                        count++;
                    }
                }
                if(count<n/2){
                    for (int j = 0; j < n; j++) {
                        map.get(j).set(i,!map.get(j).get(i));
                    }
                }
            }
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!map.get(i).get(j)){
                        tmp++;
                    }
                }
            }
            min = Math.min(min,tmp);
            mask++;
            for (int i = 0; i < n; i++) {
                var list = map.get(i);
                list.clear();
                for (int j = 0; j < n; j++) {
                    list.add(back.get(i).get(j));
                }
            }
        }
        System.out.println(min);
    }
}
