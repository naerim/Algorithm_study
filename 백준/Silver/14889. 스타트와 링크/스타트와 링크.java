import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, arr[][], min;
    public static boolean select[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE; // 최솟값을 찾아야 함으로 최대값으로 초기화해줌
        select = new boolean[N];
        combination(0, 0);
        System.out.println(min);
    }

    public static void combination(int start, int cnt) {
        if(cnt==N/2) { // 모두 뽑으면
            int first = 0;
            int second = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(select[i]&&select[j]) { // 모두 선택되었을때
                        first += arr[i][j];
                    }
                    else if(!select[i]&&!select[j]) {// 모두 선택되지 않았을때
                        second += arr[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(first-second)); // 차이가 작은 값 찾기
            return;
        }

        for(int i=start; i<N; i++) {
            select[i] = true;
            combination(i+1, cnt+1);
            select[i] = false;
        }
    }


}
