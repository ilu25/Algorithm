import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length / 2;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        // N/2와 가지 수 중 작은 게 답
        answer = Math.min(answer, hm.size());
        
        return answer;
    }
}