import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int map[][] = new int[5][5];
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 빙고판 입력
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // 사회자가 부른 수 입력
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }

        int answer = 0;
        while(!queue.isEmpty()) {
            int n = queue.poll();

            answer++;
            change(n);
            if(check_bingo()) {
                break;
            }
        }

        System.out.println(answer);
    }

    public static void change(int n) {
        loop:
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(map[i][j] == n) {
                    map[i][j] = -1;
                    break loop;
                }
            }
        }
    }

    public static boolean check_bingo() {
        int check = 0;

        // 가로 확인
        for(int i=0; i<5; i++) {
            int count = 0;
            for(int j=0; j<5; j++) {
                if(map[i][j] == -1) count++;
            }
            if(count == 5) check++;
        }
        // 세로 확인
        for(int i=0; i<5; i++) {
            int count = 0;
            for(int j=0; j<5; j++) {
                if(map[j][i] == -1) count++;
            }
            if(count == 5) check++;
        }

        // 대각선 확인
        // 00 11 22 33 44
        int count = 0;
        for(int i=0; i<5; i++) {
            if(map[i][i] == -1) count++;
        }
        if(count == 5) check++;

        // 04 13 22 31 40
        count = 0;
        for(int i=0; i<5; i++) {
            if(map[i][4-i] == -1) count++;
        }
        if(count == 5) check++;

        return check >= 3 ?  true :  false;
    }
}
