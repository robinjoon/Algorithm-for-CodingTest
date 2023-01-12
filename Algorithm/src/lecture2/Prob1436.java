package lecture2;

import java.util.Scanner;

/*
 * 제한시간이 2초이고, 범위가 10000 => 완전탐색
 */
public class Prob1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 666;
        int result = 1;
        while (true){
            if (result == n)break;
            num++;
            if(String.valueOf(num).contains("666"))result++;
        }
        System.out.println(num);
    }
}
