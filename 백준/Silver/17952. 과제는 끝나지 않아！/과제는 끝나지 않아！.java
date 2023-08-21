
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());// 분기 갯수
		int answer = 0; // 정답
		
		Stack<int[]> stack = new Stack<>(); // 업무가 몇분 남았는지, 업무의 점수를 저장할 stack 선언
		
		for(int n=1; n<=N; n++) { // 분기 갯수만큼 반복
			st = new StringTokenizer(br.readLine());
			
			if(st.countTokens() == 1) { // 토큰수가 1개일때 => 0일때
				if(!stack.isEmpty()) { // 업무가 남아있을 때
					int[] s = stack.pop(); // 가장 최근 업무 꺼내기
					if(s[0]-1==0) { // 남아있던 업무를 끝냈을 때 점수추가
						answer += s[1];
					} else {
						stack.push(new int[] {s[0]-1, s[1]}); // 남아있는 시간 빼주고 다시 넣어주기
					}
				}
			} else { // 0이 아니고 새로운 업무가 주어졌을 때
				st.nextToken(); // 첫번째 값
				int score = Integer.parseInt(st.nextToken()); // 업무의 점수
				int time = Integer.parseInt(st.nextToken()); // 몇분 남았는지
				
				if(time-1==0) { // 업무가 주어지자마자 끝났을 때 점수추가
					answer += score;
				} else {
					stack.push(new int[] {time-1, score}); // stack에 새로운 일 추가
				}
			}
		}
		
		System.out.println(answer); // 정답 출력
	}

}
