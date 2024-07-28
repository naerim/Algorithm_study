import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K  = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a=0, b=0, answer=0;
        int cnt[] = new int[100001];

        while(b < arr.length) {
            while(b < arr.length && cnt[arr[b]] + 1 <= K) {
                cnt[arr[b]]++;
                b++;
            }
            answer = Math.max(answer, b-a);
            cnt[arr[a]]--;
            a++;
        }

        System.out.println(answer);
    }
}
