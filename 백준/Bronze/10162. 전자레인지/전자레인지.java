

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 요리 시간
		int answer[] = new int[3]; // 정답(최소 버튼 조작 갯수)
		
		// A:300초, B:60초, C:10초
		int A = T/300; // 최대 사용할 수 있는 A의 조작횟수
		outer:
		for(int i=A; i>=0; i--) { // 지정된 시간이 큰 버튼을 누를 수록 조작 횟수가 줄어든다.
			if((i*300)==T) { // 요리시간과 같으면
				answer[0] = i;
				break;
			}
			int B = (T-i*300)/60; // 최대 사용할 수 있는 B의 조작횟수
			for(int j=B; j>=0; j--) {
				int remain = T - (i*300+j*60);
				if(remain==0) { // 요리시간과 같으면
					answer[0] = i; // A 사용횟수
					answer[1] = j; // B 사용횟수
					break outer; // 가장 바깥으로 빠져나감, 반복문 종료
				}
				if(remain%10 == 0) { // C까지 사용했을 때 요리시간과 같으면
					answer[0] = i; // A 사용횟수
					answer[1] = j; // B 사용횟수
					answer[2] = remain/10; // C 사용횟수
					break outer; // 가장 바깥으로 빠져나감, 반복문 종료
				}
			}
		}
		
		if(answer[0]==0 && answer[1]==0 && answer[2]==0) { // 초기화값이 0이기 때문에 요리시간과 일치하는 시간을 만들지 못했을 경우
			System.out.println(-1);
		} else {
			System.out.printf("%d %d %d%n", answer[0], answer[1], answer[2]);
		}
	}
}
