import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node>{
		int x;
		int y;
		int d;
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.d, node.d);
		}
		
	}

	public static int tc = 1; // 테이스케이스
	public static int N, map[][];
	public static int[] dx = {-1,1,0,0}; // 방향벡터
	public static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N==0) break; // 반복문 종료
			
			map = new int[N][N];
			for(int i=0; i<N; i++) { // 입력 받기
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 우선순위 큐에 시작점 넣기
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0, map[0][0]));
			
			// 최소길이 저장할 배열
			int distance[][] = new int[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE); // 최대값으로 초기화
			}
			distance[0][0] = map[0][0];
						
			while(!pq.isEmpty()) {
				Node current = pq.poll();
				
				if(current.d > distance[current.x][current.y]) continue;
				for(int i=0; i<4; i++) {
					int nx = current.x + dx[i];
					int ny = current.y + dy[i];
					
					if((nx>=0&&nx<N)&&(ny>=0&&ny<N)) {
						if(distance[nx][ny] > distance[current.x][current.y] + map[nx][ny]) {
							distance[nx][ny] = distance[current.x][current.y] + map[nx][ny];
							pq.offer(new Node(nx, ny, map[nx][ny]));
						}
					}
				}
			}
			
			
			System.out.println("Problem " + tc +": " + distance[N-1][N-1]); // 정답 출력
			tc++;
		}
	}

}
