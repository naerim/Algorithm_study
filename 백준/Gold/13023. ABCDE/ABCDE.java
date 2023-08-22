import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static class Node {
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	public static int N, M, answer, count;
	public static Node list[];
	public static boolean visited[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new Node[N];
		visited = new boolean[N];
		
		for(int i=0; i<M; i++) { // 그래프 생성
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a] = new Node(b, list[a]);
			list[b] = new Node(a, list[b]);
		}
		
		for(int i=0; i<N; i++) {
			count = 0;
			visited = new boolean[N];
			dfs(i);
		}
		System.out.println(answer);
	}
	
	public static void dfs(int current) {
		
		visited[current] = true; // 방문 처리
		count++;
		if(count==5) answer = 1;
		if(answer==1) return;
		
		for(Node temp=list[current]; temp!=null; temp=temp.next) {
			if(!visited[temp.vertex]) {
				dfs(temp.vertex);
				visited[temp.vertex] = false;
			}
		}
		
		count--;
	}

}
