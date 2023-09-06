import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N]; // 온도 저장할 배열
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int num = 0; // 더한값을 저장할 변수
        for(int i=0; i<K; i++) { // 맨처음 K개만큼 더해서 max값 지정
            answer += arr[i];
            num += arr[i];
        }

        for(int i=K; i<N; i++) {
            num = num - arr[i-K] + arr[i]; // 가장 앞의 값 빼주고 뒤의 값 더하기
            answer = Math.max(answer, num);
        }

        System.out.println(answer);
    }
}
