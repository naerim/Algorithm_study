import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int input[] = new int[3];
		input[0] = Integer.parseInt(st.nextToken());
		input[1] = Integer.parseInt(st.nextToken());
		input[2] = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num0 = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			num0 += Math.min(input[1], input[2]);
			num1 += Math.min(input[0], input[2]);
			num2 += Math.min(input[0], input[1]);
			
			input[0] = num0;
			input[1] = num1;
			input[2] = num2;
		}
		
		int answer = input[0];
		for(int i=1; i<3; i++) {
			answer = Math.min(answer, input[i]);
		}
		
		System.out.println(answer);
	}

}
