import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기화
        char[] cArr = st.nextToken().toCharArray();
        List<Character> editor = new LinkedList<>();
        for (char c : cArr) {
            editor.add(c);
        }

        // 편집
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        ListIterator<Character> li = editor.listIterator();
        // 커서 맨 뒤로 보내기
        while (li.hasNext()) {
            li.next();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken().charAt(0)) {
                case 'L': {
                    if (li.hasPrevious()) {
                        li.previous();
                    }
                    break;
                }
                case 'D': {
                    if (li.hasNext()) {
                        li.next();
                    }
                    break;
                }
                case 'B': {
                    if (li.hasPrevious()) {
                        li.previous();
                        li.remove();
                    }
                    break;
                }
                case 'P': {
                    char newChar = st.nextToken().charAt(0);
                    li.add(newChar);
                    break;
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (char c : editor) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}