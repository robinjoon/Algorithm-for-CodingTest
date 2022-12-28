package lecture1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Prob9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            Map<String,Integer> map = new HashMap<>();
            int n = Integer.parseInt(reader.readLine());
            for (int j = 0; j < n; j++) {
                String input = reader.readLine();
                String[] inputs = input.split(" ");
                if(map.containsKey(inputs[1])){
                    map.put(inputs[1], map.get(inputs[1])+1);
                }else {
                    map.put(inputs[1],1);
                }
            }
            int count = 1;
            for (String key:map.keySet()) {
                count *= map.get(key)+1;
            }
            System.out.println(count-1);
        }
    }
}
