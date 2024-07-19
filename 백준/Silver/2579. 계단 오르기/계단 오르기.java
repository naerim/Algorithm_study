import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int stairs[], dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stairs = new int[N+1];
        dp = new int[N+1];

        for(int i=1; i<=N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = stairs[1];
        if(N==1) {
            System.out.println(dp[1]);
        } else {
            dp[2] = dp[1] + stairs[2];
            for(int i=3; i<=N; i++) {
                dp[i] = Math.max(dp[i-2], dp[i-3]+stairs[i-1]) + stairs[i];
            }
            System.out.println(dp[N]);
        }

    }

}
