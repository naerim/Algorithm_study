import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, max_height, limit, answer;
    static int arr[][];
    static int dx[] = new int[] {1, 0, -1, 0};
    static int dy[] = new int[] {0, 1, 0, -1};
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        max_height = 0; // 최대 높이

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max_height = Math.max(arr[i][j], max_height);
            }
        }

        for(int t=1; t<=max_height; t++) {
            limit = t;
            visited = new boolean[N][N];

            int count = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j] && arr[i][j]-limit>0) {
                        bfs(i, j);
                        count++;
                    }
                }

                answer = Math.max(count, answer);
            }
        }

        if(answer == 0) {
            System.out.println(1);
        } else System.out.println(answer);

    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            for(int k=0; k<4; k++) {
                int nx = q[0] + dx[k];
                int ny = q[1] + dy[k];
                if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && arr[nx][ny]-limit>0) {
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

}
