import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static int N, arr[], lis[];
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1; testcase<=T; testcase++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N];
			lis = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) { // 배열 입력 받기
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				lis[i] = 1;
				for(int j=0; j<i; j++) {
					if(arr[i] > arr[j]) {
						lis[i] = Math.max(lis[i], lis[j]+1);
					}
				}
			}
			
			int answer = 0;
			for(int i=0; i<N; i++) {
				answer = Math.max(answer, lis[i]);
			}
			
			System.out.println("#" + testcase + " " + answer);
		}
		
	}

}