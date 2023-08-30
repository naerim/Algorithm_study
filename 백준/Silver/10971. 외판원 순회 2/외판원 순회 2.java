import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		
		input = new int[N];
		select = new boolean[N];
		
		min = Integer.MAX_VALUE;
		permutation(0);
		System.out.println(min);
	}
	
	public static void permutation(int cnt) {
		
		if(cnt==N) {
			int total = 0;
			for(int i=1; i<N; i++) {
				if(arr[input[i-1]][input[i]] == 0) return;
				total += arr[input[i-1]][input[i]];
			}
			if(arr[input[N-1]][input[0]] == 0) return;
			
			total += arr[input[N-1]][input[0]];
			min = Math.min(min, total);
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
