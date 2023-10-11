import java.util.*;

class Point implements Comparable<Point>{
    int x;
    int y;
    int count; // 움직인 횟수
    Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
    @Override
    public int compareTo(Point p) {
        return Integer.compare(this.count, p.count);
    }
}

class Solution {
    public int n, m;
    public boolean visited[][];
    public int dx[] = {-1,1,0,0}; // 방향벡터
    public int dy[] = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        int answer = -1;
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m]; // 방문 배열
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(0,0,1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            Point q = queue.poll();
            
            if(q.x==n-1 && q.y==m-1) {
                answer = q.count;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int nx = q.x + dx[i];
                int ny = q.y + dy[i];

                if((nx>=0&&nx<n)&&(ny>=0&&ny<m)&&!visited[nx][ny]&&maps[nx][ny]==1) {
                    queue.offer(new Point(nx, ny, q.count+1));
                    visited[nx][ny] = true;
                }
            }
        }

        return answer;
    }
}