/**
 * 1. C개에서 L개 조합으로 뽑기
 * 2. 모음개수 1개이상, 자음개수 2개이상 되는지 확인
 * 3. 위의 조건을 만족한다면 순열 돌리기(오름차순)
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int L, C;
	static char arr[], input[];
	static boolean isSelected[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		input = new char[L];
		isSelected = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		selectPassword(0, 0);
		
	}
	
	public static void selectPassword(int cnt, int start) { // 조합으로 뽑기
		if(cnt==L) {
			if(checkPassword()) {
				for(int i=0; i<L; i++) {
					System.out.print(input[i]);
				}
				System.out.println();
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			input[cnt] = arr[i];
			selectPassword(cnt+1, i+1);
		}
	}

	public static boolean checkPassword() { // 모음1개이상, 자음2개이상인지 확인
		int vowel = 0; // 모음
		int consonant = 0; // 자음
		
		for(int i=0; i<input.length; i++) {
			if(input[i] == 'a' || input[i] == 'e' || input[i] == 'i' || input[i] == 'o' || input[i] == 'u') {
				vowel++;
			} else {
				consonant++;
			}
		}
		
		if(vowel>=1 && consonant>=2) return true;
		return false;
	}
}
