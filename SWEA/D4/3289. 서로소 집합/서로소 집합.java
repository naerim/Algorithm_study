import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int N, M, parents[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase=1; testcase<=T; testcase++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N
			M = Integer.parseInt(st.nextToken()); // 연산의 갯수
			
			sb.append("#"+testcase+ " ");
			make(); // 첫 집합 생성
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(first==0) { // 합집합 수행
					union(a, b);
				} else { // 포함되어있는지 확인하는 연산
					sb.append(find(a)==find(b) ? 1 : 0);
				}
			}
			sb.append("\n");
		}

		
		System.out.println(sb.toString());
	}

	public static void make() {
		parents = new int[N+1];
		for(int i=0; i<N+1; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) { // 부모 찾기
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static void union(int a, int b) { // 합집합
		a = find(a);
		b = find(b);
		
		if(a!=b) parents[b] = a;
	}
}