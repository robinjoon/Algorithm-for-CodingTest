package lecture1;

import java.util.Scanner;
/*
(A+B) % C = (A%C + B%C)%C
(A-B) % C = (A%C - B%C)%C
(A*B) % C = (A%C * B%C)%C
 */
public class Prob1629 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(square(a,b,c));
    }
    private static long square(long a,long b,long c){
        if(b == 1) return a%c;
        if(b==0) return 1;
        if(b%2==0){
            long tmp = square(a,b/2,c);
            return (tmp%c * tmp%c) % c;
        }else {
            long tmp = square(a,(b-1)/2,c);
            return (a%c * tmp%c * tmp%c)%c;
        }
    }
}
