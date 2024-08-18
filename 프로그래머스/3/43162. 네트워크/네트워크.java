import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // bfs
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n]; // 방문배열

        for(int c=0; c<n; c++) {
            if(!visited[c]) {
                queue.add(c);
                visited[c] = true;
                answer++;
                
                while(!queue.isEmpty()) {
                    int q = queue.poll();

                    for(int i=0; i<n; i++) {
                        if(q==i) continue;
                        if(computers[q][i]==1 && !visited[i]) {
                            queue.add(i);
                            visited[i] = true;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}