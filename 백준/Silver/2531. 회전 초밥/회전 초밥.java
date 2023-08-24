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

        arr = new int[N];
        for(int i=0; i<N; i++) { // 입력받기
            arr[i] = Integer.parseInt(br.readLine());
        }

        selected = new int[d+1]; // 선택된 접시 저장할 배열

        int front = 0; // 앞 포인터
        int back = k-1; // 뒤 포인터

        // 처음 k개수 만큼 선택된 접시 넣어주기
        for(int i=front; i<=back; i++) {
            selected[arr[i]] += 1;
        }
        selected[c] += 1; // 이벤트 접시 추가
        max = countChobob(); // 먹은 접시의 개수

        while(back<N-1) {
            selected[arr[front++]]--; // 맨 앞의 값 빼주기
            selected[arr[++back]]++; // 맨 뒤의 값 넣기
            int count = countChobob(); // 사용된 서로 다른 접시의 개수
            max = Math.max(max, count);
        }

        while(front < N) { // 뒤의 사이클 확인
            selected[arr[front++]]--;
            selected[arr[front+k-N-1]]++;
            int count = countChobob(); // 사용된 서로 다른 접시의 개수
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    public static int countChobob() {
        int count = 0;
        for(int i=0; i<d+1; i++) {
            if(selected[i] != 0) count++;
        }
        return count;
    }

}

