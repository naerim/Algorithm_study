/*
    절단기의 값을 최솟값과 최대값의 중간값으로 설정해주면서 계산한다.
    설정한 절단기로 나무를 잘랐을때 총 길이가 M보다 크면 설정한 절단기의 최소 높이를 +1 해주고
    M보다 작다면 설정한 절단기의 최대 높이를 -1 해주면서 절단기의 최대 높이를 찾는다.
    -> 이분탐색
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[N]; // 나무 길이를 담을 배열
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]); // 최대값 찾기
        }

        while(start <= end) {
            int mid = (start+end)/2;
            long sum = 0; // 가져갈 나무 길이
            for(int i=0; i<N; i++) {
                if(arr[i] > mid) sum += arr[i]-mid;
            }
            if(sum >= M) start=mid+1; // M보다 크다면 설정한 절단기의 최소 높이 +1
            else end=mid-1; // M보다 작다면 설정한 절단기의 최대 높이 -1
        }
        System.out.println(end);
    }
}
