/**
 * BJ 10971 외판원순회2
 * 
 * 순열을 통해 순서를 정한 후 서로 인접해 있는지 확인한다.
 * 
 * 메모리 12948 KB
 * 시간 364 ms
 * 
 * @author 김내림
 * 
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, arr[][], input[], min;
	static boolean select[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 도시의 수
		arr = new int[N][N]; // 인접 행렬 배열
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		input = new int[N]; // 뽑은 숫자를 저장할 배열
		select = new boolean[N]; // 방문 여부 저장할 배열
		
		min = Integer.MAX_VALUE; // 최솟값을 찾아야하기 때문에 가장 큰 값으로 초기화
		permutation(0); // 순열 실행
		System.out.println(min);
	}
	
	public static void permutation(int cnt) {
		
		if(cnt==N) {
			int total = 0;
			for(int i=1; i<N; i++) {
				if(arr[input[i-1]][input[i]] == 0) return; // 연결되어 있지 않으면 계산 안하고 바로 종료
				total += arr[input[i-1]][input[i]];
				if(total>min) return;
			}
			if(arr[input[N-1]][input[0]] == 0) return; // 연결되어 있지 않으면 계산 안하고 바로 종료
			
			total += arr[input[N-1]][input[0]];
			min = Math.min(min, total); // 최소값 갱신
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(select[i]) continue;
			select[i] = true;
			input[cnt] = i;
			permutation(cnt+1);
			select[i] = false;
		}
	}
}
