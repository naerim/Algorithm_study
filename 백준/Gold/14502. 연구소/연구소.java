import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }
    }

    public static int N,M,max;
    public static List<Point> list = new ArrayList<>(); // 빈 칸 위치를 담은 리스트
    public static String map[][]; // 연구소 지도 배열
    public static String target[][];
    public static int select[]; // 벽 세울 3개의 빈칸의 인덱스 저장할 배열
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0}; // 오른쪽 아래 왼쪽 위

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = st.nextToken();
                if(map[i][j].equals("0")) {
                    list.add(new Point(i, j));
                }
            }
        }

        select = new int[3];

        comb(0, 0); // 조합으로 벽 세울 3개의 빈칸 찾기

        System.out.println(max);

    }

    public static void comb(int cnt, int start) {
        if(cnt == 3) {
            target = new String[N][M];
            for(int i=0; i<N; i++) { // 배열 복사
                for(int j=0; j<M; j++) {
                    target[i][j] = map[i][j];
                }
            }

            fillWall(); // 벽 세우기

            int count = countSafeArea(target); // 안전 영역 크기 세기
            max = Math.max(count, max);
            return;
        }

        for(int i=start; i<list.size(); i++) {
            select[cnt] = i;
            comb(cnt+1, i+1);
        }
    }

    public static void fillWall() {
        for(int i=0; i<3; i++) {
            int index = select[i];
            target[list.get(index).x][list.get(index).y] = "1";
        }
    }

    public static int countSafeArea(String arr[][]) {
        // bfs로 바이러스 퍼지게
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j].equals("2")) {
                    queue.add(new Point(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            Point q = queue.poll();
            int index = 0;
            while(index < 4) {
                int nx = q.x + dx[index];
                int ny = q.y + dy[index];
                if((nx>=0&&nx<N) && (ny>=0&&ny<M) && !arr[nx][ny].equals("1") && !visited[nx][ny]) {
                    arr[nx][ny] = "2";
                    queue.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                } else index++;
            }
        }

        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j].equals("0")) {
                    count++;
                }
            }
        }
        return count;
    }
}
