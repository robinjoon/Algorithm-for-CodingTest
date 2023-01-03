package lecture2;

import java.util.Scanner;
/*
이차원 배열과 좌표계
배열의 첫번째 차원은 y 좌표이고, 배열의 두번째 차원은 x 좌표이다.
 */
public class Prob1992 {
    private static StringBuffer stringBuffer = new StringBuffer();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] input = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input[j]=='1'?1:0;
            }
        }
        make(arr,new int[]{0,0}, new int[]{n,n},n);
        System.out.print(stringBuffer);
    }
    private static void make(int[][] arr, int[] start,int[] end,int n){
        if(n==0)return;
        int bracket = needBracket(arr,start,end);
        if(bracket==-1){
            stringBuffer.append("(");
        }else {
            stringBuffer.append(bracket);
            return;
        }
        n = n/2;
        make(arr,start,new int[]{start[0]+n,start[1]+n},n);
        int[] nextStart = new int[]{start[0],start[1]+n};
        make(arr,nextStart,new int[]{nextStart[0]+n,nextStart[1]+n},n);
        nextStart = new int[]{start[0]+n,start[1]};
        make(arr,nextStart,new int[]{nextStart[0]+n,nextStart[1]+n},n);
        nextStart = new int[]{start[0]+n,start[1]+n};
        make(arr,nextStart,new int[]{nextStart[0]+n,nextStart[1]+n},n);
        if(bracket==-1){
            stringBuffer.append(")");
        }
    }
    private static int needBracket(int[][] arr, int[] start,int[] end){
        int check = arr[start[0]][start[1]];
        for (int i = start[0]; i < end[0]; i++) {
            for (int j = start[1]; j < end[1]; j++) {
                if(check!=arr[i][j])return -1;
            }
        }
        return check;
    }
}
