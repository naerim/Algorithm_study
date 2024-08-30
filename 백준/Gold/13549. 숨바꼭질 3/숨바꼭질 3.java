import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int pos;
        int sec;
        public Node(int pos, int sec) {
            this.pos = pos;
            this.sec = sec;
        }
    }
    static int N,K;
    static int answer;
    static boolean visited[] = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Deque<Node> deque = new LinkedList<>();
        deque.add(new Node(N, 0));
        visited[N] = true;

        while (!deque.isEmpty()) {
            Node q = deque.poll();
            visited[q.pos] = true;

            if(q.pos == K) {
                answer = q.sec;
                break;
            }

            if(q.pos*2 <= 100000 && !visited[q.pos*2]) {
                deque.addFirst(new Node(q.pos*2, q.sec));
            }
            if(q.pos+1 <= 100000 && !visited[q.pos+1]) {
                deque.addLast(new Node(q.pos+1, q.sec+1));
            }
            if(q.pos-1 >= 0 && !visited[q.pos-1]) {
                deque.addLast(new Node(q.pos-1, q.sec+1));
            }

        }

        System.out.println(answer);

    }
}
