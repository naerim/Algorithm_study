import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	public static class Point {
		int x;
		int y;
		int no;
		public Point(int x, int y, int no) {
			this.x = x;
			this.y = y;
			this.no = no;
		}
	}

	public static int N, H, W, arr[][], map[][], input[], min;
	public static int dx[] = {0,0,-1,1};
	public static int dy[] = {-1,1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1; testcase<=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			
			arr = new int[H][W];
			map = new int[H][W];
			for(int i=0; i<H; i++) { // 입력 받기
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			input = new int[N]; // 구슬 떨어트릴 위치
			dfs(0);
			System.out.printf("#%d %d\n", testcase, min);
		}
	}
	
	public static void dfs(int cnt) {
		if(cnt == N) { // N번 구슬 떨어트릴 위치 모두 뽑았을때 (중복순열)
			if(min != 0) {
				// 배열 초기화
				for(int i=0; i<H; i++) {
					for(int j=0; j<W; j++) {
						map[i][j] = arr[i][j];
					}
				}
				destroyBlock(); // 벽돌 파괴하기
				int count = countBlock(); // 남은 벽돌 갯수
				min = Math.min(min, count);
			}
			return;
		}
		
		for(int i=0; i<W; i++) {
			input[cnt] = i;
			dfs(cnt+1);
		}
	}
	
	public static void destroyBlock() { // 블록 파괴하는 함수 : bfs
		for(int n: input) {
			// 블록 파괴하기 전에 블록이 하나도 없으면 그냥 종료
			if(isEmptyMap()) {
				min = 0;
				break;
			}
			
			int row = findRow(n); // 파괴할 행 찾기
			if(row==-1) continue; // 파괴할 벽돌 없으면 continue
			
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(row, n, map[row][n]));
			
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				map[p.x][p.y] = 0; // 현재 블록 파괴

				for(int i=0; i<4; i++) { // 4방향으로 탐색
					int index = 0;
					int x = p.x;
					int y = p.y;
					
					while(index < p.no-1) {
						int nx = x + dx[i];
						int ny = y + dy[i];
						if((nx>=0&&nx<H)&&(ny>=0&&ny<W)) {
							x = nx;
							y = ny;
							if(map[nx][ny]!=0) {
								queue.add(new Point(nx, ny, map[nx][ny]));
							}
						}
						index++;
					}
				}
			}
			
			// 빈칸 지우기
			removeBlank();
		}

	}
	
	public static int findRow(int k) { // 파괴할 행 찾는 함수 : 0이 아닌 값이 있을 경우 그 행 반환
		for(int i=0; i<H; i++) {
			if(map[i][k] != 0) return i;
		}
		return -1;
	}
	
	public static boolean isEmptyMap() { // 벽돌이 하나라도 있으면 false 반환하는 함수
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] != 0) return false;
			}
		}
		return true;
	}
	
	public static void removeBlank() { // 빈 영역 지우기
		for(int i=0; i<W; i++) {
			Stack<Integer> stack = new Stack<>();
			for(int j=0; j<H; j++) {
				if(map[j][i]!=0) { // 빈 영역이 아니면 stack에 넣어주기
					stack.push(map[j][i]);
					map[j][i]=0;
				}
			}
			
			int row = H-1;
			while(!stack.empty()) { // 끝에서부터 값 넣기
				map[row--][i] = stack.pop();
			}
		}
	}
	
	public static int countBlock() { // 남은 벽돌 갯수 세기
		int count = 0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j] != 0) count += 1;
			}
		}
		return count;
	}

}
