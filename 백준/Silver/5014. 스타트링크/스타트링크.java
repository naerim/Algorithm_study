import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        public int position;
        public int move;
        public Point(int position, int move) {
            this.position = position;
            this.move = move;
        }
    }
    static int F, S, G, U, D, answer;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        answer = -1;
        visited = new boolean[F+1];

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(S, 0));
        visited[S] = true;

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(p.position == G) {
                answer = p.move;
            }
            // up
            int np = p.position + U;
            if(np>0 && np<=F && !visited[np]) {
                queue.add(new Point(np, p.move+1));
                visited[np] = true;
            }
            // down
            np = p.position - D;
            if(np>0 && np<=F && !visited[np]) {
                queue.add(new Point(np, p.move+1));
                visited[np] = true;
            }
        }

        if(answer == -1) {
            System.out.println("use the stairs");
        } else System.out.println(answer);

    }
}
