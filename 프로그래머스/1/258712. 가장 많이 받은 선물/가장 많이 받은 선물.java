class Solution {
    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;
        int arr[][] = new int[N][N]; // 주고받은 횟수 (주는사람, 받는사람)
        int score[] = new int[N]; // 선물 지수
        int answer[] = new int[N]; // 선물 받을 횟수
        
        for(String gift:gifts) {
            String name1 = gift.split(" ")[0];
            String name2 = gift.split(" ")[1];
            
            int index1=-1, index2 = -1;
            
            for(int i=0; i<N; i++) { // 번호 찾기
                if(friends[i].equals(name1)) index1 = i;
                if(friends[i].equals(name2)) index2 = i;
            }
            
            arr[index1][index2]++;
            score[index1]++; // 선물 준 사람 선물지수 +1
            score[index2]--; // 선물 받은 사람 선물지수 -1
        }
        
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(arr[i][j] > arr[j][i]) { // i가 j한테 선물을 더 많이 줬다면
                    answer[i]++;
                } else if(arr[i][j] < arr[j][i]) {
                    answer[j]++;
                } else { // 같다면 선물비수 비교
                    if(score[i] > score[j]) answer[i]++;
                    else if(score[j] > score[i]) answer[j]++;
                }
            }
        }
        
        int max = 0;
        for(int n: answer) {
            max = Math.max(max, n);
        }
        
        return max;
    }
}