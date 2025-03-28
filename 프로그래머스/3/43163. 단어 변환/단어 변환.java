import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[] visited;
    
    // 6:12 ~ 
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        DFS(begin, target, words, 0);
        return answer;
    }
    
    static void DFS(String current, String target, String[] words, int step) {
        if (current.equals(target)) {
            answer = step; 
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                // 글자가 하나만 다른지 확인
                if (canVisit(current, words[i])) {
                    visited[i] = true;
                    DFS(words[i], target, words, step + 1);
                    visited[i] = false;
                }
            }
        } 
    }
    
    static boolean canVisit(String current, String next) {
        int count = 0;  // 글자 다른 개수
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != next.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}