import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
        static ArrayList[] direction;
    static int N, start, level[], max_level;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int testcase=1; testcase<=10; testcase++) {
            direction = new ArrayList[101]; // 1~100개의 정점

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 입력받을 데이터의 길이
            start = Integer.parseInt(st.nextToken()); // 연락 시작할 정점

            for(int i=0; i<=100; i++) { // 방향 배열 초기화
                direction[i] = new ArrayList();
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N/2; i++) { // from-to 쌍이므로 N/2만큼 반복 -> 방향 배열에 넣기
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                if(!isExist(from, to)) {
                    direction[from].add(to);
                }
            }

            level = new int[101];
            bfs();

            for(int i=100; i>=0; i--) {
                if(max_level == level[i]) { // 최대깊이와 같은 인덱스 찾아서 반환
                    sb.append("#" + testcase + " " + i+"\n");
                    break;
                }
            }

        }
        System.out.println(sb.toString());
    }

    public static boolean isExist(int index, int v) { // 값이 존재하는지 확인
        for(int i=0; i<direction[index].size(); i++) {
            if(direction[index].get(i).equals(v)) return true;
        }
        return false;
    }

    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean isVisited[] = new boolean[101];

        queue.offer(start); // 시작 정점 큐에 추가
        isVisited[start] = true;
        level[start] = 1; // 현재 깊이 1

        while(!queue.isEmpty()) {
            int q = queue.poll(); // 큐에서 값 빼기

            for(int i=0; i<direction[q].size(); i++) {
                int n = (Integer) direction[q].get(i);
                if(!isVisited[n]) {
                    queue.offer(n);
                    isVisited[n] = true;
                    level[n] = level[q]+1; // 현재 깊이+1
                    max_level = level[q]+1; // 깊이 갱신
                }
            }
        }
    }
}