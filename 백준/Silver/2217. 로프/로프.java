import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N]; // 로프 저장할 배열
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 오름차순

        long answer = 0;
        for(int i=N-1; i>=0; i--) {
            long n = arr[i] * (N-i); // 사용갯수만큼 곱하기
            if(answer < n) answer = n; // 최대값 갱신
        }
        System.out.println(answer);
    }
}
