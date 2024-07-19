import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, total;
    static int apps[], costs[];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        apps = new int[N+1];
        costs = new int[N+1];
        dp = new int[N+1][10001];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) { // 앱
            apps[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) { // 비용
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            for(int j=0; j<=10000; j++) {
                if(j < costs[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-costs[i]]+apps[i]);
                }
            }
        }

        for(int i=0; i<=10000; i++) { // M 바이트 이상의 메모리를 확보하는 최소 비용 찾기
            if(dp[N][i] >= M) {
                System.out.println(i);
                return;
            }
        }
    }
}
