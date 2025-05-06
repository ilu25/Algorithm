import java.util.*;
import java.io.*;

public class Main {
    static class State {
        int screen, clipboard, time;
        
        State(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        System.out.println(minTimeToMakeEmoticons(S));
    }

    public static int minTimeToMakeEmoticons(int S) {
        // 현재 이모티콘 수, 클립보드의 이모티콘 수, 소요 시간 저장
        Set<String> visited = new HashSet<>();	// 화면, 클립보드
        Queue<State> queue = new LinkedList<>();

        queue.offer(new State(1, 0, 0));
        visited.add("1,0");

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.screen == S) {
                return current.time;
            }

            // 현재 화면의 이모티콘을 클립보드에 복사
            String newState1 = current.screen + "," + current.screen;
            if (!visited.contains(newState1)) {
                visited.add(newState1);
                queue.offer(new State(current.screen, current.screen, current.time + 1));
            }

            // 클립보드의 이모티콘을 화면에 붙여넣기
            if (current.clipboard > 0) {
                String newState2 = (current.screen + current.clipboard) + "," + current.clipboard;
                if (!visited.contains(newState2)) {
                    visited.add(newState2);
                    queue.offer(new State(current.screen + current.clipboard, current.clipboard, current.time + 1));
                }
            }

            // 화면의 이모티콘 하나 삭제
            if (current.screen > 0) {
                String newState3 = (current.screen - 1) + "," + current.clipboard;
                if (!visited.contains(newState3)) {
                    visited.add(newState3);
                    queue.offer(new State(current.screen - 1, current.clipboard, current.time + 1));
                }
            }
        }
        return -1;
    }
}