import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int map[][];
    public static List<Point> list = new ArrayList<>(); // 0 위치를 담을 리스트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        map = new int[9][9];

        for(int i=0; i<9; i++) {
            String s = br.readLine();
            for(int j=0; j<9; j++) {
                map[i][j] = s.charAt(j) - '0';
                if(map[i][j] == 0) list.add(new Point(i, j));
            }
        }

        sudoku(0); // 스도쿠 진행

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean sudoku(int cnt) {
        if(cnt==list.size()) return true; // 답이 완성되었을때

        int x = list.get(cnt).x;
        int y = list.get(cnt).y;
        for(int i=1; i<=9; i++) { // 1부터 9까지 가능한지 확인
            map[x][y] = i;
            if(isCheck(x,y) && sudoku(cnt+1)) return true;
        }

        map[x][y] = 0;
        return false;
    }

    public static boolean isCheck(int x, int y) { // 값이 들어갈 수 있는지 확인
        for(int i=0; i<9; i++) {
            if (x != i && map[i][y] == map[x][y]) return false; // 세로줄 확인
            if (y != i && map[x][i] == map[x][y]) return false; // 가로줄 확인
        }

        // 3x3방향 탐색 (3으로 나눈 몫에 *3 하면 x값)
        for(int i=(x/3)*3, ni=0; ni<3; i++,ni++) {
            for(int j=(y/3)*3, nj=0; nj<3; j++, nj++) {
                if(i != x && j != y && map[i][j] == map[x][y]) return false;
            }
        }

        return true;
    }
}
