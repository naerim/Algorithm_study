import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int number = Integer.parseInt(st.nextToken());

            int count = 0;
            for(int j=0; j<N; j++) {
                if(arr[j]==0) {
                    if(count == number) {
                        arr[j] = i+1;
                        break;
                    }
                    count++;
                }
            }
        }

        for(int i=0; i<N; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
