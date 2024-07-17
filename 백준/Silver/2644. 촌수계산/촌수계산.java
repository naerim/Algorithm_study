import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, index1, index2, M, answer;
    static int arr[][];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        answer = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        index1 = Integer.parseInt(st.nextToken());
        index2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        dfs(index1, 0);
        System.out.println(answer);
    }

    public static void dfs(int start, int cnt) {
        visited[start] = true;

       for(int i=0; i<=N; i++) {
           if(arr[start][i] != 0 && !visited[i]) {
               if(i == index2) {
                   answer = cnt + 1;
                   return;
               }
               dfs(i, cnt+1);
           }
       }
    }

}
