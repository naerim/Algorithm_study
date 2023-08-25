import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int vertex, weight;
		Node next;

		public Node(int vertex, Node next, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", next=" + next + "]";
		}
		
		
	}
	static int V, E, K, distances[];
	static Node nodelist[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		K = Integer.parseInt(br.readLine()); // 시작 정점
		
		nodelist = new Node[V+1]; // 인접배열리스트 생성
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken()); // 가중치
			nodelist[u] = new Node(v, nodelist[u], w);
		}
		
		distances = new int[V+1];
		findMin();
		
		for(int i=1; i<distances.length; i++) {
			if(distances[i]==Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else sb.append(distances[i]+"\n");
		}
		System.out.println(sb.toString());
		
		
	}
	
	public static void findMin() {
		boolean visited[] = new boolean[V+1];
		
		Arrays.fill(distances, Integer.MAX_VALUE); // 최소 거리를 넣어줄 것이기 때문에 가장 큰 값으로 초기화
		distances[K] = 0; // 시작할 정점과의 거리 0
		
		int min = Integer.MAX_VALUE;
		int index=0;
		
		for(int i=0; i<V; i++ ) {
			
			index = 0;
			min = Integer.MAX_VALUE;
			for(int j=1; j<=V; j++) {
				if(!visited[j] && min > distances[j]) {
					min = distances[j];
					index = j;
				}
			}
			
			if(index==0) break;
			
			visited[index] = true;

			for(Node n=nodelist[index]; n!=null; n=n.next) {
				if(!visited[n.vertex] && distances[n.vertex] > min+n.weight) {
					distances[n.vertex] = min+n.weight;
				}
			}
		}

		
		
	}

}
