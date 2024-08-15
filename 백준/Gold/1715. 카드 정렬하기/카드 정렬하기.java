import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            answer += first + second;
            pq.add(first + second);
        }

        System.out.println(answer);
    }
}
