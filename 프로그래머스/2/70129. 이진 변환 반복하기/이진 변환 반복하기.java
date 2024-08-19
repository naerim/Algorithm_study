import java.util.*;

class Solution {
    public int[] solution(String s) {
        int count = 0; // 변환 횟수
        int zero_count = 0; // 0의 갯수
        
        while(!s.equals("1")) {
            
            count++;
            
            String new_text = "";
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i)=='1') new_text += "1";
                else zero_count++;
            }
            
            int len = new_text.length();
            
            s = Integer.toBinaryString(len);
        }
        
        return new int[] {count, zero_count};
    }
}