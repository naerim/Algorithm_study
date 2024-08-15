import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int arr[] = new int[3];
        int first[] = {1,2,3,4,5};
        int second[] = {2,1,2,3,2,4,2,5};
        int third[] = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0; i<answers.length; i++) {
            int num = answers[i];
  
            if(num == first[i%5]) arr[0]++;
            if(num == second[i%8]) arr[1]++;
            if(num == third[i%10]) arr[2]++;
        }
        
        int max = -1;
        for(int i=0; i<3; i++) {
            max = Math.max(max, arr[i]);
        }
        
        for(int i=0; i<3; i++) {
            if(arr[i]==max) answer.add(i+1);
        }
        
        
        int answer_arr[] = new int[answer.size()];
        
        for(int i=0; i<answer.size(); i++) {
            answer_arr[i] = answer.get(i);
        }
        
        
        return answer_arr;
    }
}