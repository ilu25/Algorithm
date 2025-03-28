import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[] visited;
    static int[] steps;
    
    // 6:12 ~ 
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        steps = new int[words.length];
        
        int targetIdx = Arrays.asList(words).indexOf(target);
        DFS(begin, target, words, 1);
        
        if (targetIdx != -1) {
            answer = steps[targetIdx];
        }
        return answer;
    }
    
    static void DFS(String current, String target, String[] words, int step) {
        if (current.equals(target)) {
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                // 글자가 하나만 다른지 확인
                if (canVisit(current, words[i])) {
                    visited[i] = true;
                    if (steps[i] == 0) {
                        steps[i] = step;
                    }
                    else {
                        steps[i] = Math.min(steps[i], step);
                    }
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