import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static int N;
	public static long arr[][];
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1; testcase<=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			arr = new long[N][N]; // 인접행렬배열
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = Long.parseLong(st.nextToken());
					if(arr[i][j]==0) arr[i][j] = Integer.MAX_VALUE;
				}
			}
			
			for(int k=0; k<N; k++) { // 경유지
				for(int i=0; i<N; i++) { // 출발지
					for(int j=0; j<N; j++) { // 도착지
						arr[i][j] = Math.min(arr[i][k] + arr[k][j], arr[i][j]);
					}
				}
			}
			
			long min = Long.MAX_VALUE;
			
			// 최소 찾기
			for(int i=0; i<N; i++) {
				long sum = 0;
				for(int j=0; j<N; j++) {
					if(i == j) continue;
					sum += arr[i][j];
				}
				min = Math.min(min, sum);
			}
			
			sb.append(String.format("#%d %d\n", testcase, min));
			
		}
		System.out.println(sb);
	}
}