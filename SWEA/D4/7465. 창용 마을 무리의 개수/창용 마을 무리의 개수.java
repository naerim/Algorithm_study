import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static int N,M,arr[][], group;
	public static boolean visited[]; // 방문 배열
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1; testcase<=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1][N+1];
			visited = new boolean[N+1];
			group = 0; // 현재 마을의 갯수
			
			while(M-->0) {
				st = new StringTokenizer(br.readLine());
				
				int count = st.countTokens();
				if(count == 2) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					arr[a][b] = 1;
					arr[b][a] = 1;
				}
			}
			
			for(int n=1; n<=N; n++) {
				if(!visited[n]) bfs(n); // 방문한적이 없을때 bfs 실행
			}
			
			// 정답 출력
			System.out.printf("#%d %d\n", testcase, group);
		}
	}

	public static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		visited[n] = true;
		
		while(!queue.isEmpty()) {
			int q = queue.poll();
			for(int i=1; i<=N; i++) {
				if(arr[q][i]==1 && !visited[i]) { // 연결되어있고 방문한적이 없을때
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		
		group++; // bfs 종료시 마을 갯수 추가
	}
}
