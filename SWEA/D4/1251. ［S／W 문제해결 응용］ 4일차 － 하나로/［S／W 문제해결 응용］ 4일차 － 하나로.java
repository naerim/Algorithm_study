import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution
{
	public static class Vertex implements Comparable<Vertex>{
		int no;
		long width;
		public Vertex(int no, long width) {
			super();
			this.no = no;
			this.width = width;
		}
		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.width, o.width);
		}
		
	}
	
	static int N;
	static long islands[][];
	static double E, result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1; testcase<=T; testcase++) {
			N = Integer.parseInt(br.readLine()); // 섬의 개수
			
			islands = new long[N][2]; // 섬들의 x좌표, y좌표 저장한 배열
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) { // x 좌표
				islands[i][0] = Long.parseLong(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) { // y 좌표
				islands[i][1] = Long.parseLong(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine()); // 세율
			
			result = 0;
			prim();
			sb.append(String.format("#%d %.0f%n", testcase, result));
		}
		System.out.println(sb.toString());
		
	}
	
	public static void prim() {
		boolean isVisited[] = new boolean[N]; // 방문 배열
		PriorityQueue<Vertex> queue = new PriorityQueue<>(); // 우선순위 큐 생성
		
		queue.offer(new Vertex(0, 0)); // 첫번째 섬 넣기
		long min = 0; // 최소 거리
		int min_index = 0, cnt=0; // 최소 거리를 가지는 섬의 인덱스, 방문한 섬의 갯수를 셀 인덱스
		
		while(!queue.isEmpty()) {
			Vertex current = queue.poll();
			
			min_index = current.no; // 최소 거리를 가지는 섬의 인덱스
			min = current.width; // 최소 거리
			
			if(isVisited[min_index]) continue;
			
			isVisited[current.no] = true; // 현재 큐에서 뺀 값 방문 처리
			
			result += E*current.width;
			if(++cnt==N) break;
			
			
			for(int i=0; i<N; i++) {
				if(!isVisited[i]) {
					long current_width = (long)Math.pow(islands[i][0]-islands[current.no][0],2) + (long)Math.pow(islands[i][1]-islands[current.no][1],2); // 두 섬 사이의 거리
					queue.offer(new Vertex(i, current_width));
				}
			}
			
		}
		
	}
}