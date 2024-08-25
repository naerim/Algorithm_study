import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M, answer;
    static boolean visited[][];
    static int map[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            if(check()) {
                answer = 0;
                break;
            }
            if(count_mountains() >= 2) break;
            answer++;
            melts();
        }

        System.out.println(answer);

    }

    public static int count_mountains() { // 분리되는 빙산 갯수 return 하는 함수
        int count = 0;
        visited = new boolean[N][M]; // 방문 배열

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        return count;
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int q[] = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = q[0] + dx[i];
                int ny = q[1] + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void melts() { // 녹는 빙산 계산하는 함수
        int newMap[][] = new int[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) continue;
                int count = 0;
                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0) {
                        count++;
                    }
                }
                newMap[i][j] = map[i][j] - count;
                if(newMap[i][j] <= 0) newMap[i][j] = 0;
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j] = newMap[i][j];
            }
        }
    }

    public static boolean check() { // 빙산이 다 녹았는지 확인하는 함수
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]!=0) return false;
            }
        }
        return true;
    }
}
