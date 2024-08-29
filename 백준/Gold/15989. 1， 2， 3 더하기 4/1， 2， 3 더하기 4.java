import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int dp[][] = new int[4][10001];
        dp[0][0] = 1;

        for(int i=1; i<4; i++) {
            for(int j=0; j<10001; j++) {
                if(i>j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i][j-i] + dp[i-1][j];
            }
        }

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[3][N]);
        }
    }
}
