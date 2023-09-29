import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Point {
        public int x;
        public int y;
        public int time;
        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static int R, C;
    public static char[][] map;
    public static Queue<Point> animal = new LinkedList<>(); // 고슴도치 위치 저장할 리스트
    public static Queue<Point> water = new LinkedList<>(); // 물의 위치를 저장할 리스트
    public static int answer = Integer.MAX_VALUE;
    public static int[] dx = {-1,0,1,0}; // 위우하좌
    public static int[] dy = {0,1,0,-1}; // 위우하좌
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int i=0; i<R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S') { // 고슴도치
                    animal.add(new Point(i,j,0));
                } else if(map[i][j] == '*') { // 물
                    water.add(new Point(i, j, 0));
                }
            }
        }

        move();

        if(answer == Integer.MAX_VALUE) { // 정답이 갱신이 안되었다면
            System.out.println("KAKTUS");
        } else {
            System.out.println(answer);
        }
    }

    public static void move() {
        while(!animal.isEmpty()) { // 고슴도치가 존재할때까지
            // 물 이동
            int size = water.size();
            for(int i=0; i<size; i++) {
                Point p = water.poll();

                for(int j=0; j<4; j++) { // 네 방향으로 퍼질 수 있는지 확인
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if((nx>=0&&nx<R)&&(ny>=0&&ny<C)&&map[nx][ny]=='.') { // 갈 수 있다면
                        map[nx][ny] = '*';
                        water.add(new Point(nx, ny, 0));
                    }
                }
            }

            // 고슴도치 이동
            size = animal.size();
            for(int i=0; i<size; i++) {
                Point p = animal.poll();

                for(int j=0; j<4; j++) { // 네 방향으로 퍼질 수 있는지 확인
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    int time = p.time;
                    if((nx>=0&&nx<R)&&(ny>=0&&ny<C)) { // 범위 안에 있다면
                        if(map[nx][ny] == 'D') { // 비버굴이라면
                            answer = Math.min(answer, time+1);
                        } else if(map[nx][ny] == '.') { // 이동할 수 있다면
                            map[nx][ny] = 'S'; // 이동
                            animal.add(new Point(nx, ny,time+1));
                        }
                    }
                }
            }
        }
    }
}
