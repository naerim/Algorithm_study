import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,H;
    static int arr[][][];
    static int dz[] = {0, 0, 0, 0, 1, -1};
    static int dx[] = {0, 0, 1, -1, 0, 0};
    static int dy[] = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        int count = 0, answer=0;
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k]==1) {
                        queue.add(new int[] {i, j, k});
                    } else if(arr[i][j][k]==0) {
                        count++;
                    }
                }
            }
        }

        while(count>0 && !queue.isEmpty()) {
            for(int s=queue.size(); s>0; s--) {
                int[] q = queue.poll();

                for(int i=0; i<6; i++) {
                    int nz = q[0] + dz[i];
                    int nx = q[1] + dx[i];
                    int ny = q[2] + dy[i];
                    if(nz>=0&&nz<H&&nx>=0&&nx<N&&ny>=0&&ny<M&&arr[nz][nx][ny]==0) {
                        arr[nz][nx][ny]=1;
                        queue.add(new int[]{nz, nx, ny});
                        count--;
                    }
                }
            }
            answer++;
        }

        System.out.println(count == 0 ? answer : -1);
    }
}
