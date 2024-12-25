import java.util.Scanner;

class Main {
    static int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] eng = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        int totalDays = 0;
        for (int i = 1; i < month; i++) {
            totalDays += daysOfMonth[i];
        }
        totalDays += day - 1;   // 1월 1일 = 0

        System.out.println(eng[totalDays % 7]);
    }
}