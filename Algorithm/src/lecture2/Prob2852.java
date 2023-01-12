package lecture2;

import java.util.Scanner;

public class Prob2852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int totalWinTime = 0;
        int totalWinTime2 = 0;
        int startWinTime =0;
        int endWinTime;
        int startWinTime2=0;
        int endWinTime2;
        int score = 0,score2 = 0;
        for (int i = 0; i < n; i++) {
            int goalTeam = sc.nextInt();
            if(goalTeam == 1)score++;
            else score2++;
            String str = sc.next();
            if(score-score2==1 && goalTeam==1){
                startWinTime = Integer.parseInt(str.split(":")[0])*60 + Integer.parseInt(str.split(":")[1]);
            }else if(score2-score==1 && goalTeam ==2){
                startWinTime2 = Integer.parseInt(str.split(":")[0])*60 + Integer.parseInt(str.split(":")[1]);
            }
            if(score == score2){
                if(goalTeam==1){
                    endWinTime2 = Integer.parseInt(str.split(":")[0])*60 + Integer.parseInt(str.split(":")[1]);
                    totalWinTime2 += endWinTime2 - startWinTime2;
                }else{
                    endWinTime = Integer.parseInt(str.split(":")[0])*60 + Integer.parseInt(str.split(":")[1]);
                    totalWinTime += endWinTime - startWinTime;
                }
            }
        }
        if(score>score2){
            totalWinTime+=48*60 - startWinTime;
        }else if(score2>score){
            totalWinTime2+=48*60 - startWinTime2;
        }
        System.out.printf("%02d:%02d\n",totalWinTime/60,totalWinTime%60);
        System.out.printf("%02d:%02d\n",totalWinTime2/60,totalWinTime2%60);
    }
}
