import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(s.length() - 1 - i) - '0');
            if (i % 3 == 2) {
                int oct = 0;
                for (int j = 0; j < 3; j++) {
                    oct += (int) (list.get(j) * Math.pow(2, j));
                }
                sb.append(oct);
                list.clear();
            }
        }

        if (!list.isEmpty()) {
            int oct = 0;
            for (int i = 0; i < list.size(); i++) {
                oct += (int) (list.get(i) * Math.pow(2, i));
            }
            sb.append(oct);
        }

        sb.reverse();
        System.out.println(sb);
    }
}