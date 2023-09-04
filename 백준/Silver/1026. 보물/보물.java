import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int a[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int b[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(a);
        Arrays.sort(b);

        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += a[i] * b[N-1-i]; // a는 오름차순, b는 내림차순 한 값으로 곱해서 더한다.
        }
        System.out.println(sum);
    }
}
