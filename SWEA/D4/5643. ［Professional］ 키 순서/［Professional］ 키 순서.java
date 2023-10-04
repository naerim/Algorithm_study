import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution
{
	public static int N,M,arr[][], reverse_arr[][],result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1; testcase<=T; testcase++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			arr = new int[N+1][N+1];
			reverse_arr = new int[N+1][N+1];
			result = 0;
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
				reverse_arr[b][a] = 1;
			}
			
			for(int i=1; i<=N; i++) {
				boolean visited[] = new boolean[N+1]; // 방문 배열
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				visited[i] = true;
				// 순방향 인접리스트
				while(!queue.isEmpty()) {
					int q = queue.poll();
					
					for(int j=1; j<=N; j++) {
						if(!visited[j] && arr[q][j]==1) {
							queue.add(j);
							visited[j] = true;
						}
					}
				}
				
				queue.add(i);
				// 역방향 인접리스트
				while(!queue.isEmpty()) {
					int q = queue.poll();
					
					for(int j=1; j<=N; j++) {
						if(!visited[j] && reverse_arr[q][j]==1) {
							queue.add(j);
							visited[j] = true;
						}
					}
				}
				
				// 모두 방문했는지 확인
				int count = 0;
				for(int j=1; j<=N; j++) {
					if(visited[j]) count++;
				}
				if(count==N) result++;
			}
			
			System.out.printf("#%d %d\n", testcase, result);
			
		}
	}
}