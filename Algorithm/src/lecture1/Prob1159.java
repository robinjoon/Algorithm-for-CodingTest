package lecture1;

import java.util.*;
//https://www.acmicpc.net/problem/1159
/*
국가대표팀의 감독이 된 이후에 상근이는 매우 게을러졌다. 그는 선수의 이름을 기억하지 못하고, 각 선수의 능력도 알지 못한다. 따라서, 누가 선발인지 기억하기 쉽게 하기 위해 성의 첫 글자가 같은 선수 5명을 선발하려고 한다. 만약, 성의 첫 글자가 같은 선수가 5명보다 적다면, 상근이는 내일 있을 친선 경기를 기권하려고 한다.

상근이는 내일 경기를 위해 뽑을 수 있는 성의 첫 글자를 모두 구해보려고 한다.

입력
첫째 줄에 선수의 수 N (1 ≤ N ≤ 150)이 주어진다. 다음 N개 줄에는 각 선수의 성이 주어진다. (성은 알파벳 소문자로만 이루어져 있고, 최대 30글자이다)

출력
상근이가 선수 다섯 명을 선발할 수 없는 경우에는 "PREDAJA" (따옴표 없이)를 출력한다. PREDAJA는 크로아티아어로 항복을 의미한다. 선발할 수 있는 경우에는 가능한 성의 첫 글자를 사전순으로 공백없이 모두 출력한다.
 */
public class Prob1159 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Character,Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            char firstName = str.charAt(0);
            if(countMap.containsKey(firstName)){
                countMap.put(firstName,countMap.get(firstName)+1);
            }else {
                countMap.put(firstName,1);
            }
        }
        List<Character> answer = new ArrayList<>();
        countMap.forEach((c,i)->{
            if(countMap.get(c)>=5)answer.add(c);
        });
        if(answer.isEmpty()){
            System.out.print("PREDAJA");
        }
        answer.sort(Comparator.naturalOrder());
        answer.forEach(System.out::print);
    }
}
