import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            if(K==1) {
                System.out.println("1 1");
                continue;
            }

            int arr[] = new int[26];

            for(int i=0; i<W.length(); i++) {
                arr[W.charAt(i)-'a']++;
            }

            int min = 10001;
            int max = 0;

            for(int i=0; i<W.length(); i++) {
                if(arr[W.charAt(i)-'a'] < K) continue;

                int cnt=1;
                for(int j=i+1; j<W.length(); j++) {
                    if(W.charAt(i) == W.charAt(j)) cnt++;
                    if(cnt==K) {
                        min  = Math.min(min, j-i+1);
                        max  = Math.max(max, j-i+1);
                        break;
                    }
                }
            }

            if(min == 10001 || max == 0) {
                System.out.println(-1);
                continue;
            }

            System.out.println(min + " " + max);
        }
    }
}
