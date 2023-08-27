import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution
{
    static class Core {
        int x, y;

        public Core(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

    }
    static int N, arr[][], select[], selectNum, min;
    static int dx[] = {1,0,-1,0}; // 상,우,좌,하
    static int dy[] = {0,1,0,-1};
    static ArrayList<Core> cores;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int testcase = 1; testcase <= T; testcase++) {
            N = Integer.parseInt(br.readLine()); // 셀 크기 입력
            arr = new int[N][N];

            cores = new ArrayList<>();
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 1) { // 해당 셀에 멕시노스(1)가 있다면
                        if(i != 0 && j != 0) { // 가장자리가 아니라면 코어 추가
                            cores.add(new Core(i, j));
                        }
                    }
                }
            }

            for(int i=cores.size(); i>0; i--) {
                selectNum = i;
                select = new int[i];
                min = Integer.MAX_VALUE; // 전선길이의 합 최소
                comb(0, 0); // 연결 확인할 코어 조합을 통해 지정하기
                if(min < Integer.MAX_VALUE) break; // 최솟값 찾으면 종료
            }

            System.out.printf("#%d %d%n", testcase, min);

        }
    }

    public static void comb(int start, int cnt) {
        if(cnt==selectNum) {
            dfs(0, 0);
            return;
        }

        for(int i=start; i<cores.size(); i++) {
            select[cnt] = i;
            comb(i+1, cnt+1);
        }
    }

    public static void dfs(int cnt, int num) {

        if(cnt==selectNum) { // 모두 연결되면
            min = Math.min(min, num); // 최솟값 갱신
            return;
        }

        for(int i=0; i<4; i++) {
            int len = 0; // 선 길이
            int x = cores.get(select[cnt]).x; // 선택한 core의 x좌표
            int y = cores.get(select[cnt]).y; // 선택한 core의 y좌표
            boolean success = false;
            while(true) {
                x = x + dx[i];
                y = y + dy[i];
                if(x<0 || x>=N || y<0 || y>=N) { // 범위 벗어나면 성공
                    success = true;
                    break;
                }
                if(arr[x][y] != 0) { // 전선이나 코어 만나면 실패
                    break;
                }
                arr[x][y] = 1; // 전선 표시
                len++;
            }
            if(success) { // 전선 만들 수 있을 때
                dfs(cnt+1, num+len);
            }
            while(true) { // 원래 상태로 돌려놓기
                x = x - dx[i];
                y = y - dy[i];
                if(x==cores.get(select[cnt]).x && y==cores.get(select[cnt]).y) break;
                arr[x][y] = 0;
            }
        }
    }
}