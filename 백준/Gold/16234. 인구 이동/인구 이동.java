import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N,L,R,map[][],day;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static boolean visited[][], flag;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        day = 0; // 정답

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            visited = new boolean[N][N];
            flag = false; // 탈출 조건

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(visited[i][j]) continue; // 이미 방문한적이 있다면
                    bfs(new Point(i, j));
                }
            }

            if(!flag) {
                break;
            } else day++;
        }

        System.out.println(day);
    }

    public static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> union = new LinkedList<>(); // 연합국 좌표 저장할 queue
        queue.add(point);
        union.add(point);

        visited[point.x][point.y] = true;
        int sum = 0; // 인구수 더한값
        int count = 0; // 연합국 갯수

        while (!queue.isEmpty()) {
            Point q = queue.poll();
            int x = q.x;
            int y = q.y;
            sum += map[q.x][q.y];
            count++;

            for(int i=0; i<4; i++) { // 하상우좌
                int nx = x + dx[i];
                int ny = y + dy[i];
                if((nx>=0&&nx<N) && (ny>=0&&ny<N) && !visited[nx][ny]) {
                    int diff = Math.abs(map[x][y] - map[nx][ny]);

                    if(diff>=L && diff<=R) { // 범위안에 들어가 있다면
                        flag = true;
                        visited[nx][ny] = true;
                        queue.add(new Point(nx, ny));
                        union.add(new Point(nx, ny));
                    }
                }
            }
        }
        sum /= count;
        while(!union.isEmpty()) {
            Point p = union.poll();
            map[p.x][p.y] = sum;
        }
    }
}
