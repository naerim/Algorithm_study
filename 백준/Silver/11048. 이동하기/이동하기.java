import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 세로 길이
		int M = Integer.parseInt(st.nextToken()); // 가로 길이
		
		int arr[][] = new int[N][M];
		int candy[][] = new int[N][M];
		
		for(int i=0; i<N; i++) { // 배열 입력 받기
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		candy[0][0] = arr[0][0];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i==0 && j==0) continue;
				if(i==0) {
					candy[i][j] = arr[i][j] + candy[i][j-1];
					continue;
				}
				if(j==0) {
					candy[i][j] = arr[i][j] + candy[i-1][j];
					continue;
				}
				// 상
				candy[i][j] = candy[i-1][j] + arr[i][j];
				// 좌상
				if(arr[i-1][j-1]+arr[i][j] > candy[i][j]) candy[i][j] = candy[i-1][j-1]+arr[i][j];
				// 좌
				if(candy[i][j-1]+arr[i][j] > candy[i][j]) candy[i][j] = candy[i][j-1]+arr[i][j];
			
			}
		}
		
		System.out.println(candy[N-1][M-1]);
	}

}
