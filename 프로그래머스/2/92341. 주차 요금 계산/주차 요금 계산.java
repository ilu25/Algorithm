import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        /* 
            9:17 ~ 10:39
            - 입차 내역을 (차량 번호, 시각) 해시맵에 넣으면서 출차 시 빼기 
                -> (차량 번호, 누적 주차 시간)에 계산
            - 그래도 남은 건 23:59에서 빼기
            - (차량 번호, 누적 주차 시간)에 따라 answer에 넣기 (오름차순)
        */
        HashMap<String, String> parking = new HashMap<>();  // 차량 번호별 입차 시각
        HashMap<Integer, Integer> times = new HashMap<>();  // 차량 번호별 누적 주차 시간
        
        // 입차인 경우 parking에 추가
        // 출차인 경우 parking에서 제거 -> 누적 주차 시간 계산해서 times에 추가
        for (String record : records) {
            String[] input = record.split(" ");
            String time = input[0];
            String carNum = input[1];
            String inOut = input[2];
            
            if (inOut.equals("IN")) {
                parking.put(carNum, time);
            }
            else {
                int sumTime = getSumTime(time, parking.get(carNum));
                parking.remove(carNum);
                
                // 이전에 출차했었는지 확인
                int num = Integer.parseInt(carNum);
                if (times.containsKey(num)) {
                    times.put(num, sumTime + times.get(num));
                }
                else {
                    times.put(num, sumTime);
                }
            }
        }
        
        // 출차가 없는 경우 23:59로 누적 주차 시간 계산
        for (String key : parking.keySet()) {
            // 이전에 출차했었는지 확인
            int sumTime = getSumTime("23:59", parking.get(key));
            int carNum = Integer.parseInt(key);
            
            if (times.containsKey(carNum)) {
                times.put(carNum, sumTime + times.get(carNum));
            }
            else {
                times.put(carNum, sumTime);
            }
        }
        
        // 차량 번호 작은 순으로 정렬
        List<Integer> carNums = new ArrayList<>(times.keySet());
        Collections.sort(carNums);
        
        // 누적 주차 시간별 요금 구하기
        int[] answer = new int[times.size()];
        for (int i = 0; i < times.size(); i++) {
            int exceededTime = times.get(carNums.get(i)) - fees[0];
            int exceededFee = (int)Math.ceil(exceededTime / Double.valueOf(fees[2])) * fees[3];
            answer[i] = exceededTime > 0 ? fees[1] + exceededFee : fees[1]; 
        }
        
        return answer;
    }
    
    static int getSumTime(String outTime, String inTime) {
        String[] out = outTime.split(":");
        int outMinutes = Integer.parseInt(out[0]) * 60 + Integer.parseInt(out[1]);
        
        String[] in = inTime.split(":");
        int inMinutes = Integer.parseInt(in[0]) * 60 + Integer.parseInt(in[1]);
        
        return outMinutes - inMinutes;
    }
}