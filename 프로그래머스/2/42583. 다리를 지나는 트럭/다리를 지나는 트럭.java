import java.util.*;

class Solution {  
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;     // 다리에 트럭 올라갈 때만 증가
        int currentWeight = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        
        for (int truck : truck_weights) {
            while (true) {
                // 다리 개수 꽉 찬 경우
                if (bridge.size() == bridge_length) {
                    currentWeight -= bridge.poll();
                }
                // 다리 무게 넘는 경우 (이동만)
                else if (currentWeight + truck > weight) {
                    bridge.offer(0);
                    answer++;
                }
                else {
                    bridge.offer(truck);
                    currentWeight += truck;
                    answer++;
                    break;
                }
            }
        }
        // 마지막 트럭 이동 시간
        return answer + bridge_length;
    }
}

/* 
    9:22 ~ 
    - 대기 큐, 다리 큐
    - 다리 큐에 올릴 때 무게를 넘지 않으면 올리기, 넘으면 빼기 (대기 큐 없을 때까지)
    (9:46) 문제 잘못 이해 -> 시간 초과
    
    - 무게 초과 시 다리에 있는 트럭들 이동 = 0 넣기
    - iterator로 현재 다리 무게 구하지 말고, 변수에다 저장하기
    - 대기 큐 대신 for문으로 트럭들 판단해서 다리에 올라갈 때 다음 트럭으로 이동(break)
    - 다리에서 내려올 땐 시간 추가 X
*/