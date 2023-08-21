import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, K, min;
	public static boolean isVisited[] = new boolean[100001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		min = 0;
		
		if(N==K) { // 위치가 같으면 0 출력
			System.out.println(0);
		} else {
			bfs();
			System.out.println(min);
		}
		
	}
	
	public static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {N, 0}); // 현재 위치, 움직인 횟수
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			
			if(temp[0]==K) {
				min = temp[1];
				break;
			}
			
			if(temp[0]*2<isVisited.length && !isVisited[temp[0]*2]) {
				queue.add(new int[] {temp[0]*2, temp[1]+1});
				isVisited[temp[0]*2] = true;
			}
			
			if(temp[0]+1<isVisited.length && !isVisited[temp[0]+1]) {
				queue.add(new int[] {temp[0]+1, temp[1]+1});
				isVisited[temp[0]+1] = true;
			}
			
			if(temp[0]-1>=0 && !isVisited[temp[0]-1]) {
				queue.add(new int[] {temp[0]-1, temp[1]+1});
				isVisited[temp[0]-1] = true;
			}
		}
	}

}
