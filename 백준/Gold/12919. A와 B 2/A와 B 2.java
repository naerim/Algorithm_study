import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();
        int answer = 1;

        if(dfs(T)) {
            System.out.println(1);
        } else System.out.println(0);

    }

    static boolean dfs(String str) {
        if(str.length() == S.length()) {
            if(str.equals(S)) return true;
            return false;
        }

        if(str.charAt(str.length()-1) == 'A') {
            if(dfs(str.substring(0, str.length()-1))) {
                return true;
            }
        }

        if(str.charAt(0) == 'B') {
            if(dfs(new StringBuilder(str.substring(1)).reverse().toString())) {
                return true;
            }
        }

        return false;
    }
}
