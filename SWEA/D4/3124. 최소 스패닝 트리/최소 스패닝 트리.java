import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution
{
	static class Node implements Comparable<Node>{
		int from, to;
		long weight;
		public Node(int from, int to, long weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.weight, o.weight);
		}
	}
	
	static int V, E, parents[];
	static Node[] edgeList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테이스케이스 횟수
		
		for(int testcase=1; testcase<=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점 개수
			E = Integer.parseInt(st.nextToken()); // 간선 개수
			
			edgeList = new Node[E];
			for(int i=0; i<E; i++) { // 간선리스트에 저장
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				long weight = Long.parseLong(st.nextToken());
				edgeList[i] = new Node(from, to, weight);
			}
			
			Arrays.sort(edgeList); // 간선리스트 오름차순 정렬
			
			make(); // 루트 노드 저장할 배열 생성
			
			int count = 0;
			long result = 0;
			for(Node node: edgeList) {
				if(union(node.from, node.to)) {
					result += node.weight;
					if(++count==V-1) break; // 모든 간선을 연결했다면 반복문 종료
				}
			}
			sb.append(String.format("#%d %d%n", testcase, result));
		}
		
		System.out.println(sb.toString());
	}
	
	public static void make() {
		parents = new int[V+1]; // 정점이 1부터 시작이므로
		for(int i=0; i<parents.length; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if(parents[a] == a) return a; // 부모와 자신이 같으면
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) { // 합집합
		a = find(a);
		b = find(b);
		
		if(a==b) return false;
		parents[b] = a;
		return true;
	}
}