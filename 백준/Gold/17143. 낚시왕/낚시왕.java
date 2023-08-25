import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 17143 낚시왕
 * @author youngeun
 *
 */
public class Main {
	static int R, C, M, answer = 0;
	static Shark[] sharks;
	static Shark[][] map;
	static int[] rows, cols;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 사이클 만들기
		rows = new int[R*2-2];
		cols = new int[C*2-2];
		for(int i = 0; i < R; i++) {
			rows[i] = i;
		}
		int cnt = R-2;
		for(int i = R; i < rows.length; i++) {
			rows[i] = cnt--;
		}
		for(int i = 0; i < C; i++) {
			cols[i] = i;
		}
		cnt = C-2;
		for(int i = C; i < cols.length; i++) {
			cols[i] = cnt--;
		}
		
		// 상어 정보 받기
		sharks = new Shark[M];
		map = new Shark[R][C];
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			Shark s = new Shark(r, c, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			sharks[m] = s;
			map[r-1][c-1] = s;
		}
		
		// 열 수 만큼 반복
		for(int c = 0; c < C; c++) {
			get(c);
			move();
			eat();
		}
		
		System.out.println(answer);
	}
	
	/**
	 * 상어 이동
	 */
	static void move() {
		for(Shark s : sharks) {
			if(s.dead) { // 죽은 상어
				continue;
			}
			
			if(s.d <= 2) { // 세로 이동
				s.r = (s.r+s.s) % rows.length;
			}else { // 가로 이동
				s.c = (s.c+s.s) % cols.length;
			}
		}
	}
	/**
	 * 상어 잡아먹기
	 */
	static void eat() {
		map = new Shark[R][C];
		for(Shark s : sharks) {
			if(s.dead) { // 죽은 상어
				continue;
			}
			int row = rows[s.r];
			int col = cols[s.c];
			if (map[row][col] == null) {
				map[row][col] = s;
			}
			else if(map[row][col].z < s.z) { // 기존 상어 잡아먹기
				map[row][col].dead = true;
				map[row][col] = s; // 바꾸기
			}
			else { // 잡아먹힘
				s.dead = true;
			}
		}
	}
	
	/**
	 * 상어 잡기
	 */
	static void get(int col) {
		for(int row = 0; row < R; row++) {
			if(map[row][col] != null) {
				map[row][col].dead = true;
				answer+=map[row][col].z;
				break;
			}
		}
	}
	
	static class Shark {
		int r, c, s, d, z;
		boolean dead = false;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r-1; // 행
			this.c = c-1; // 열
			this.s = s; // 속도
			this.d = d; // 이동방향
			this.z = z; // 크기
			
			changeCoor();
		}
		/**
		 * 사이클에 해당하는 인덱스로 좌표 교정하기
		 * 거꾸로 가는 경우(상, 좌)에 해당
		 */
		void changeCoor() {
			if(this.d == 1) { // 상행 -> r 교정
				this.r = rows.length - this.r;
			}else if(this.d == 4) { // 좌행 -> c 교정
				this.c = cols.length - this.c;
			}
		}
	}
}
