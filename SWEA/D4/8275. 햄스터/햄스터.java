import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int N, X, M;
    static int[] arr, answer;
    static int[][] memo;
    static int max_sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 우리 갯수
            X = Integer.parseInt(st.nextToken()); // 최대 햄스터 수
            M = Integer.parseInt(st.nextToken()); // 메모 갯수

            arr = new int[N]; // 우리 배열
            memo = new int[M][3]; // 메모 배열
            answer = new int[N]; // 결과 배열

            max_sum = -1; // 모든 햄스터의 수 최솟값

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                memo[i][0] = Integer.parseInt(st.nextToken())-1;
                memo[i][1] = Integer.parseInt(st.nextToken())-1;
                memo[i][2] = Integer.parseInt(st.nextToken());
            }

            dfs(0);

            System.out.print("#" + t + " ");
            if(max_sum == -1) {
                System.out.println(-1);
            } else {
                for(int i=0; i<N; i++) {
                    System.out.print(answer[i] + " ");
                }
                System.out.println();
            }

        }

    }

    public static void dfs(int cnt) {
        if(cnt==N) { // 배열 다 채워졌을 때
            for(int i=0; i<M; i++) { // memo 배열 돌면서 누적합 비교
                int check_sum = 0;
                for(int j=memo[i][0]; j<=memo[i][1]; j++) {
                    check_sum += arr[j];
                }
                if (check_sum != memo[i][2]) return;
            }

            int sum = 0;
            for(int i=0; i<N; i++) {
                sum += arr[i];
            }
            if(sum > max_sum) {
                max_sum = sum;
                answer = Arrays.copyOf(arr, N);
            }
            return;
        }

        for(int i=0; i<=X; i++) {
            arr[cnt] = i;
            dfs(cnt+1);
        }
    }
}
