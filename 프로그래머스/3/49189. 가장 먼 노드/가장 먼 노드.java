import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean visited[]; 
    static int arr[];
    
    public int solution(int n, int[][] edge) {
        
        visited = new boolean[n+1]; // 방문배열
        arr = new int[n+1]; // 각 노드의 간선 갯수 
        
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<Integer>());
        }
        for(int cnt[]:edge) {
            list.get(cnt[0]).add(cnt[1]);
            list.get(cnt[1]).add(cnt[0]);
        }
        
        bfs();
        
        Arrays.sort(arr);
        int maxDepth = arr[n];
        int count = 1;
        
        for(int i=0; i<n; i++) {
            if(arr[i]==maxDepth) {
                count++;
            }
        }
           
        return count;
    }
    
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int q = queue.poll();
            
            for(int cnt:list.get(q)) {
                if(visited[cnt]) {
                    continue;
                }
                queue.add(cnt);
                visited[cnt] = true;
                arr[cnt] = arr[q] + 1;
            }
        }
    }
}