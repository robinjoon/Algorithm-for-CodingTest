package lecture4;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 21; i++) {
            list.add(1);
        }
        list.add(list.size(),2);
        list.add(list.size()-2,3);
        list.add(list.size()-8,4);
        list.add(list.size()-13,5);
        list.add(list.size()-19,6);
        System.out.println(list);
    }
}
