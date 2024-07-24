import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            Point arr[] = new Point[N+2]; // 들르는 곳
            boolean visited[] = new boolean[N+2]; // 방문 배열;

            for(int i=0; i<N+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[i] = new Point(x, y);
            }

            Queue<Point> queue = new ArrayDeque<>();
            queue.add(arr[0]);
            visited[0] = true;

            while(!queue.isEmpty()) {
                Point q = queue.poll();

                for(int i=1; i<N+2; i++) {
                    if(!visited[i]) {
                        if(Math.abs(arr[i].x - q.x) + Math.abs(arr[i].y - q.y) <= 1000) {
                            queue.add(arr[i]);
                            visited[i] = true;
                        }
                    }
                }
            }

            System.out.println(visited[N+1] ? "happy" : "sad");

        }
    }
}
