import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int from, weight, len;
		int[] to;
		public Node(int from, int[] to, int len, int weight) {
			this.from = from;
			this.to = to;
			this.len = len;
			this.weight = weight;
		}
	}
	
	static int N, weights[], num, select[], min;
	static Node[] nodelist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		 N = Integer.parseInt(br.readLine()); // 구역의 개수
		 
		 weights = new int[N];
		 st = new StringTokenizer(br.readLine()); // 인구 수 입력 받기
		 for(int i=0; i<N; i++) {
			 weights[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 nodelist = new Node[N+1];
		 nodelist[0] = new Node(0, new int[] {}, 0, 0);
		 for(int i=1; i<N+1; i++) {
			 st = new StringTokenizer(br.readLine());
			 int n = Integer.parseInt(st.nextToken()); // 인접한 구역 개수
			 
			 int arr[] = new int[n]; // 도착지 저장할 배열
			 for(int j=0; j<n; j++) {
				 arr[j] = Integer.parseInt(st.nextToken());
			 }
			 
			 nodelist[i] = new Node(i, arr, n, weights[i-1]);
		 }
		 
		 min = Integer.MAX_VALUE;
		 num = 0; // 조합에서 뽑아야하는 갯수
		 for(int i=1; i<=N/2; i++) {
			 num = i;
			 select = new int[num]; // 뽑아야 하는 갯수만큼 배열 할당
			 combination(1, 0);
		 }
		 
		 if(min == Integer.MAX_VALUE) System.out.println(-1);
		 else System.out.println(min);
		 
	}
	
	public static void combination(int start, int cnt) { // 조합
		if(cnt==num) {
			bfs();
			return;
		}
		
		for(int i=start; i<=N; i++) {
			select[cnt] = i;
			combination(i+1, cnt+1);
		}
	}
	
	public static void bfs() {
		Queue<Node> queue = new ArrayDeque<Node>(); // 큐 생성
		boolean isVisited[] = new boolean[N+1]; // 방문 확인하는 배열
		
		// 우선 뽑힌 지역부터 연결되어있는지 확인하기
		queue.offer(nodelist[select[0]]); // 조합에서 첫번째로 뽑은값 넣어주기
		isVisited[nodelist[select[0]].from] = true;
		
		while(!queue.isEmpty()) {
			Node q = queue.poll(); // 큐 첫번째값 뽑기
			isVisited[q.from] = true;
			
			// select배열에 값이 있거나 방문한적없으면 큐에 추가하기
			for(int i=0; i<q.to.length; i++) { // 현재 노드가 갈 수 있는 도착지만큼 확인
				if(!isVisited[q.to[i]] && isExist(q.to[i])) {
					queue.offer(nodelist[q.to[i]]);
				}
			}
		}
		
		// 방문한 갯수와 뽑은 지역의 갯수가 같지 않다면 연결되지 않은 것 -> 함수 종료
		if (num!=countVisited(isVisited)) return;
		
		// 남은 지역 연결되어 있는지 확인
		queue.clear(); // 큐 초기화
		int current = 0;
		for(int i=1; i<=N; i++) { // 조합으로 뽑은 지역이 아닌 지역 중에 첫번째 값 찾음
			if(!isExist(i)) {
				current = i;
				break;
			}
		}
		
		queue.offer(nodelist[current]); 
		isVisited[nodelist[current].from] = true;
		
		while(!queue.isEmpty()) {
			Node q = queue.poll(); // 큐 첫번째값 뽑기
			isVisited[q.from] = true;
			
			// select배열에 값이 없거나 방문한적없으면 큐에 추가하기
			for(int i=0; i<q.to.length; i++) { // 현재 노드가 갈 수 있는 도착지만큼 확인
				if(!isVisited[q.to[i]] && !isExist(q.to[i])) {
					queue.offer(nodelist[q.to[i]]);
				}
			}
		}
		
		// 모두 방문했다면 인구값 더해주기
		if (countVisited(isVisited)==N) {
			int sectionA = 0;
			int sectionB = 0;
			for(int i=1; i<=N; i++) {
				if(isExist(i)) sectionA += nodelist[i].weight; // 뽑힌 구역의 합
				else sectionB += nodelist[i].weight;
			}
			
			min = Math.min(min, Math.abs(sectionA-sectionB));
		}
	}

	public static boolean isExist(int n) { // select에 값이 존재하면  true
		for(int i=0; i<select.length; i++) {
			if(n==select[i]) return true;
		}
		return false;
	}
	
	public static int countVisited(boolean isVisited[]) { // 방문한 횟수가 몇번인지 확인
		int count = 0;
		for(int i=0; i<=N; i++) {
			if(isVisited[i]) count++;
		}
		return count;
	}
}
