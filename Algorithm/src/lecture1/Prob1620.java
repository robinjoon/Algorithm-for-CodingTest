package lecture1;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

//https://www.acmicpc.net/problem/1620
public class Prob1620 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] pokemon = new String[n+1];
        Map<String,Integer> pokemonMap = new HashMap<>();
        for (int i = 1; i < n+1; i++) {
            pokemon[i] = scanner.next();
            pokemonMap.put(pokemon[i],i);
        }
        for (int i = 0; i < m; i++) {
            String str = scanner.next();
            if(Pattern.matches("^[0-9]*$",str)){
                System.out.println(pokemon[Integer.parseInt(str)]);
            }else {
                System.out.println(pokemonMap.get(str));
            }
        }
    }
}
