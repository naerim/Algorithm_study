class Solution {
    public static int answer,len;
    
    public int solution(int[] numbers, int target) {    
        len = numbers.length;
        dfs(0, 0, numbers, target); // dfs 실행
        return answer;
    }
    
    public void dfs(int cnt, int total, int[] numbers, int target) {
        if(cnt==len) { // 다 뽑았을 때
            if(total == target) answer++; // 숫자가 같다면
            return;
        }
        
        dfs(cnt+1, total+numbers[cnt], numbers, target);
        dfs(cnt+1, total-numbers[cnt], numbers, target);
        
    }
}