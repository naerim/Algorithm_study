import java.util.*;

public class Item {
    String word; // 단어
    int count; // 단계
    public Item(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public static int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        // target이 words안에 있는지 확인 : 없으면 return 0
        int count = 0;
        for(String s:words) {
            if(s.equals(target)) count++;
        }
        if(count==0) return 0;
        else {
            bfs(begin, target, words);
        }
        return answer;
    }
    
    public void bfs(String begin, String target, String[] words) {
        int N = words.length; // 단어 배열의 길이
        int len = words[0].length(); // 한 단어의 길이
        boolean visited[] = new boolean[N]; // 방문 배열
        Queue<Item> queue = new ArrayDeque<>();
        queue.offer(new Item(begin, 0)); // 첫 단어 추가
        
        while(!queue.isEmpty()) {
            Item q = queue.poll();

            if(q.word.equals(target)) {
                answer = q.count;
                break;
            }
            
            // 단어의 각 위치에서 a-z까지 변환해주기
            for(int i=0; i<len; i++) {
                String change = "";
                // a-z까지
                for(char c='a'; c<='z'; c++) {
                    if(q.word.charAt(i)==c) continue;
                    change = q.word.substring(0,i) + c + q.word.substring(i+1);
                    
                    for(int j=0; j<N; j++) {
                        if(!visited[j] && change.equals(words[j])) {
                            queue.offer(new Item(words[j], q.count+1));
                            visited[j] = true;
                        } 
                    }
                }
            }
        }
    }
}