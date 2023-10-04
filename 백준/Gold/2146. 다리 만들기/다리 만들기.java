import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Point {
        int x;
        int y;
        int bridge;
        public Point(int x, int y, int bridge) {
            this.x = x;
            this.y = y;
            this.bridge = bridge;
        }
    }
    public static int N, map[][];
    public static boolean visited[][];
    public static int landNum = 2; // 섬 번호
    public static int dx[] = {1,-1,0,0}; // 방향벡터
    public static int dy[] = {0,0,1,-1};
    public static int min = Integer.MAX_VALUE; // 가장 짧은 다리의 길이(최솟값을 찾아야하므로 최대값으로 초기화)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 번호 할당해주기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]==1) makeLand(new Point(i, j, 0)); // 아직 할당되지 않은 섬일때(1일때)
            }
        }

        // 다리 놓기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                visited = new boolean[N][N]; // 방문 배열 초기화
                if(map[i][j]!=0) makeBridge(new Point(i, j, 0)); // 섬일때
            }
        }

        System.out.println(min);
    }

    public static void makeLand(Point p) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        visited[p.x][p.y] = true;
        map[p.x][p.y] = landNum;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if((nx>=0&&nx<N)&&(ny>=0&&ny<N)&&!visited[nx][ny]&&map[nx][ny]==1) {
                    queue.add(new Point(nx, ny, 0));
                    visited[nx][ny] = true;
                    map[nx][ny] = landNum;
                }
            }
        }
        landNum++; // 섬 번호 증가시켜주기
    }

    public static void makeBridge(Point p) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        visited[p.x][p.y] = true;
        int land = map[p.x][p.y]; // 현재 섬 번호

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if((nx>=0&&nx<N)&&(ny>=0&&ny<N)&&!visited[nx][ny]&&map[nx][ny]!=land) {
                    if(map[nx][ny]==0) { // 바다면
                        queue.add(new Point(nx, ny, point.bridge+1));
                        visited[nx][ny] = true;
                    } else { // 다른섬과 만나면
                        min = Math.min(min, point.bridge);
                    }
                }
            }
        }
    }
}
