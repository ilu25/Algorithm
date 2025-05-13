import java.io.*;
import java.util.*;

public class Main {
	static Set<Integer> canHearingTime = new HashSet<>();
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] input = br.readLine().split(" ");
    	
    	int N = Integer.parseInt(input[0]);
    	int L = Integer.parseInt(input[1]);
    	int D = Integer.parseInt(input[2]);
    	
    	int songTime = L;	// 노래 끝나는 시간
    	int endOfSongTime = (L + 5) * (N - 1);	// 마지막 노래 시작하는 시간
    	
    	// 빈 시간 추가
    	while (songTime < endOfSongTime) {
    		for (int i = 1; i < 5; i++) {
    			canHearingTime.add(songTime + i);
    		}
    		songTime += (5 + L);
    	}
    	
    	// 전화벨 시간 증가하면서 최소 시간 찾기
    	int callingTime = D;
    	endOfSongTime += L;	// 마지막 노래 끝나는 시간
    	while (true) {
    		if (callingTime > endOfSongTime || canHear(callingTime)) {
    			break;
    		}
    		
    		if (callingTime + 1 > endOfSongTime || canHear(callingTime + 1)) {
    			break;
    		}
    		    		
    		callingTime += D;
    	}
    	
    	System.out.print(callingTime);
    }
    
    static boolean canHear(int callingTime) {
    	return canHearingTime.contains(callingTime);
    }
}

/* 
 * 11:28 ~ 12:21
 * [문제]
 * - 노래 N곡 (길이 L초 통일)
 * - 노래 간 5초 조용함
 * - 전화벨 D초에 1번, 1초 동안 울림 (0초부터 시작)
 * - 노래 시작(0초) / 중간 / 끝: 전화벨 듣지 X
 * - 모든 노래 끝나도 들을 수 O
 * -> 전화벨 들을 수 있는 가장 빠른 시간
 * 
 * [풀이]
 * - 들을 수 있는 시간을 집합에 추가 + 앨범 끝나는 시간 이후인지
*/
