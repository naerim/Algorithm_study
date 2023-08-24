import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, d, k ,c, arr[], selected[], max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N+k-1]; // 사이클 돌아야하기 때문에 k-1 크기만큼 더 생성
        for(int i=0; i<N; i++) { // 입력받기
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<k-1; i++) {
            arr[N++] = arr[i];
        }

        selected = new int[d+1]; // 선택된 접시 저장할 배열

        selected[c] += 1; // 이벤트 접시 추가
        max=1; // 이벤트 접시 먹은 표시

        int front = 0; // 앞 포인터
        int back = k; // 뒤 포인터

        // 처음 k개수 만큼 선택된 접시 넣어주기
        for(int i=front; i<back; i++) {
            if(selected[arr[i]]==0) max++;
            selected[arr[i]]+= 1;
        }

        int result = max;
        for(int i=back; i<arr.length; i++) {
            selected[arr[front]]--;
            if(selected[arr[front]]==0) result--;

            if(selected[arr[i]]==0) result++;
            selected[arr[i]]++;
            max = Math.max(max, result);
            front++;
        }

        System.out.println(max);
    }

}

