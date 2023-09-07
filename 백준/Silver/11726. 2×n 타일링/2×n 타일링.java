import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N 입력
        int arr[] = new int[N+1]; // N까지의 방법의 수를 생각해야하므로 크기를 N+1로 설정

        if(N==1) System.out.println(1);
        else if(N==2) System.out.println(2);
        else {
            // 값 미리 설정
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            for (int i = 3; i <= N; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 10007; // 답이 int의 범위를 벗어나기 때문에 오버플로우가 발생 -> 나머지 저장하기
            }
            System.out.println(arr[N]);
        }
    }
}
