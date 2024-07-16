import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int map[][];
    static boolean visited[][];
    static int dx[] = {1,0,-1,0}; // 상,우,좌,하
    static int dy[] = {0,1,0,-1};
    static List<Integer> towns = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(towns.size());
        Collections.sort(towns);

        for(int i=0; i<towns.size(); i++) {
            System.out.println(towns.get(i));
        }

    }

    public static void bfs(int i, int j) {
        int count = 1;
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[] {i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int temp[] = queue.poll();

            for(int k=0; k<4; k++) {
                int nx = temp[0] + dx[k];
                int ny = temp[1] + dy[k];
                if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]&&map[nx][ny]==1) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
        towns.add(count);

    }
}
