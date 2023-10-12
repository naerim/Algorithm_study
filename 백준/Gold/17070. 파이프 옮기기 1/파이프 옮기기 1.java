import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long map[][] = new long[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long dp[][][] = new long[N+1][N+1][3]; // dp
		// 초기값 할당
		dp[1][2][0] = 1;
		
		for(int i=1; i<=N; i++) {
			for(int j=3; j<=N; j++) {
				if(map[i][j]==1) continue;
				// 가로방향에서 올 수 있는 경우
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				// 세로방향에서 올 수 있는 경우
				dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
				// 대각선방향에서 올 수 있는 경우
				if(map[i-1][j]==0&&map[i][j-1]==0) {
					dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
				}
			}
		}
		
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}

}
