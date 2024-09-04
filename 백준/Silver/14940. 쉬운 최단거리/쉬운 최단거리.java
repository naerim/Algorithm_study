import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N,M;
    static int arr[][], answer[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static Node direction;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        answer = new int[N][M];

        // 정답 배열 -1로 초기화
        for(int i=0; i<N; i++) {
            Arrays.fill(answer[i], -1);
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==2) {
                    direction = new Node(i, j); // 도착점
                    answer[i][j] = 0;
                } else if(arr[i][j]==0) {
                    answer[i][j] = 0;
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(direction);

        while(!queue.isEmpty()) {
            Node q = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if(nx>=0&&nx<N&&ny>=0&&ny<M&&answer[nx][ny]==-1) {
                    queue.add(new Node(nx, ny));
                    answer[nx][ny] = answer[q.x][q.y]+1;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
