package lecture1;

import java.util.Scanner;

public class Prob4375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int num = 1;
            int count = 1;
            while (true){
                if(num%n == 0){
                    System.out.println(count);
                    break;
                }else {
                    num = (num * 10)%n + 1%n;
                    count++;
                }
            }
        }
    }
}
