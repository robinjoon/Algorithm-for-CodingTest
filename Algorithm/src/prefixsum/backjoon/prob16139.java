package prefixsum.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class prob16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        char[] chars = str.toCharArray();
        int[][] arr = new int['z'-'a'+1][str.length()];
        for (char i = 'a'; i <='z'; i++) {
            int[] sum = new int[str.length()];
            for (int j = 0; j < str.length(); j++) {
                if(chars[j]==i){
                    sum[j]=1;
                }
            }
            for (int j = 1; j < str.length(); j++) {
                sum[j] +=sum[j-1];
            }
            arr[i-'a']=sum;
        }
        int t = Integer.parseInt(bufferedReader.readLine());
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < t; i++) {
            String query = bufferedReader.readLine();
            String[] col = query.split(" ");
            char ch = col[0].toCharArray()[0];
            int l = Integer.parseInt(col[1]);
            int r = Integer.parseInt(col[2]);
            stringBuffer.append(psum(arr[ch-'a'],l,r)).append("\n");
        }
        System.out.print(stringBuffer);
    }
    private static int psum(int[] sum,int l,int r){
        try {
            return sum[r]-sum[l-1];
        }catch (IndexOutOfBoundsException e){
            return sum[r];
        }
    }
}
