import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (N == 0 && A == 0 && B == 0) break;

            int[][] teams = new int[N][3];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                teams[i] = new int[] {
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                };
            }

            // A와 B의 거리 차이가 큰 순으로 정렬
            Arrays.sort(teams, (a, b) -> Math.abs(b[1] - b[2]) - Math.abs(a[1] - a[2]));

            long totalDistance = 0;
            List<int[]> equalDistanceTeams = new ArrayList<>();

            // 거리 차이가 있는 팀들 처리
            for (int[] team : teams) {
                int balloons = team[0];
                int distA = team[1];
                int distB = team[2];

                if (distA > distB) {  // B가 더 가까운 경우
                    if (B >= balloons) {
                        B -= balloons;
                        totalDistance += (long)distB * balloons;
                    } else {
                        totalDistance += (long)distB * B;
                        balloons -= B;
                        totalDistance += (long)distA * balloons;
                        B = 0;
                        A -= balloons;
                    }
                }
                else if (distA < distB) {  // A가 더 가까운 경우
                    if (A >= balloons) {
                        A -= balloons;
                        totalDistance += (long)distA * balloons;
                    } else {
                        totalDistance += (long)distA * A;
                        balloons -= A;
                        totalDistance += (long)distB * balloons;
                        A = 0;
                        B -= balloons;
                    }
                }
                else {
                    equalDistanceTeams.add(team);
                }
            }

            // 거리가 같은 팀들 처리
            for (int[] team : equalDistanceTeams) {
                totalDistance += (long)team[0] * team[1];
            }

            System.out.println(totalDistance);
        }
    }
}