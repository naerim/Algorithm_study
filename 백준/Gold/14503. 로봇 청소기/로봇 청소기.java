import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R, C, D, count;
    static int arr[][];
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 1;
        dfs(R, C, D);
        System.out.println(count);
    }

    public static void dfs(int x, int y, int d) {
        arr[x][y] = 2;

        for(int i=0; i<4; i++) {
            d -= 1;
            if(d < 0) d = 3;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny]==0) {
                count++;
                dfs(nx, ny, d);
                return;
            }
        }

        int dir = (d+2) % 4;
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(nx>=0 && nx<N && ny >=0 && ny<M && arr[nx][ny] != 1) {
            dfs(nx, ny, d);
        }
    }
}
