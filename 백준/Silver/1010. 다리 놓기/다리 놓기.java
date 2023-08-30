import java.util.Scanner;

public class Main {

	static int arr[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		
		for(int testcase=1; testcase<=T; testcase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			arr = new int[M+1][M+1];
			arr[1][0] = 1;
			arr[1][1] = 1;
			for(int i=2; i<=M; i++) {
				for(int j=0; j<=M; j++) {
					if(j==0 || j==M) arr[i][j] = 1;
					else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
			
			sb.append(arr[M][N] + "\n");
		}
		System.out.println(sb.toString());
	}

}
