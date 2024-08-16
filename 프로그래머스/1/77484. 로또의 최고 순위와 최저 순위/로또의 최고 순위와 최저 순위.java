import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero_count = 0; // 0갯수
        int arr[] = new int[46];
        
        for(int num:lottos) {
            if(num==0) zero_count++;
            else arr[num] = 2;
        }
        
        for(int num:win_nums) {
            if(arr[num]-1 == 1) arr[num]-=1;
        }
        
        int correct = 0; // 맞힌 갯수
        for(int num:arr) {
            if(num==1) correct++;
        }
        
        return new int[]{scores(correct+zero_count), scores(correct)};
    }
    
    public static int scores(int score) {
        switch(score) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2: 
                return 5;
            default:
                return 6;
                
        }
    }
}