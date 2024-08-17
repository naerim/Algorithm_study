class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        int count = brown + yellow;
        
        for(int i=count; i>=1; i--) {
            if(count%i==0) { // 나누어 떨어질 때
                int width = i;
                int height = count/i;
                
                int temp_brown = width*2 + (height-2)*2;
                int temp_yellow = (width*height)-temp_brown;
                
                if(brown == temp_brown && yellow == temp_yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        
        
        
        return answer;
        
    }
}