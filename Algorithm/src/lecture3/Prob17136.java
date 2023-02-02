package lecture3;

import java.util.*;

public class Prob17136 {
    public static int[] counts = new int[]{0,5,5,5,5,5};
    static int[][] map = new int[10][10];
    static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <10; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        go(0,0,0);
        System.out.println(answer==Integer.MAX_VALUE?-1:answer);
    }
    private static void go(int x,int y,int count){
        if(count>answer)return;
        if(y==10){
            go(x+1,0,count);
            return;
        }
        if(x==10){
            answer = Math.min(answer,count);
            return;
        }
        if(map[x][y]==1){
            for (int size = 5; size >=1 ; size--) {
                if(canSticker(x,y,size)){
                    sticker(x,y,size,0);
                    go(x,y+1,count+1);
                    sticker(x,y,size,1);
                }
            }
        }else{
            go(x,y+1,count);
        }
    }
    private static boolean canSticker(int x,int y, int size){
        try {
            if (counts[size] == 0) return false;
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (map[i][j] == 0) return false;
                }
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
    private static void sticker(int x,int y, int size,int value){
        for (int i = x; i <x+size ; i++) {
            for (int j = y; j <y+size ; j++) {
                map[i][j]=value;
            }
        }
        if(value==0)
            counts[size]--;
        else
            counts[size]++;
    }
}
