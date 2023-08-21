import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	public static int N, result;
	public static char arr[][];
	public static boolean visited[][];
	public static int dx[] = {-1,0,1,0};
	public static int dy[] = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		// 적록색약이 아닌 사람이 봤을 때
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) floodfill(i, j);
			}
		}
		sb.append(result + " ");
		
		result = 0; // 정답값 초기화
		for(int i=0; i<N; i++) { // 방문배열 초기화
			for(int j=0; j<N; j++) {
				visited[i][j] = false;
			}
		}
		
		// 초록색 -> 빨간색으로 변경
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]=='G') arr[i][j] = 'R';
			}
		}
		
		// 적록색약인 사람이 봤을 때
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) floodfill(i, j);
			}
		}
		sb.append(result);
		
		System.out.println(sb.toString());
		
		
	}

	public static void floodfill(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		
		queue.offer(new int[] {r, c}); // 첫번째 값 큐에 집어넣기
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			int[] q = queue.poll();

			int index = 0;
			while(index<4) {
				int nr = q[0] + dx[index];
				int nc = q[1] + dy[index];
				if((nr>=0&&nr<N)&&(nc>=0&&nc<N)&&(arr[q[0]][q[1]]==arr[nr][nc])&&!visited[nr][nc]) {
					queue.offer(new int[] {nr, nc}); // 범위안에 있고 문자가 같고 방문한적이 없다면 큐에 추가
					visited[nr][nc] = true;
				}
				index++;
			}
			
		}
		result += 1;
	}
	
}
