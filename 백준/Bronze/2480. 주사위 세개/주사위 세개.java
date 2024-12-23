import java.util.Scanner;

class Main {
    static int A, B, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        int award;

        if (checkSameThree()) {
            award = 10000 + A * 1000;
        }
        else if (checkAllDifferent()) {
            int max = Math.max(A, Math.max(B, C));
            award = max * 100;
        }
        else {
            int bonus;
            if (A != B) {
                bonus = C;
            }
            else if (B != C) {
                bonus = A;
            }
            else {
                bonus = B;
            }
            award = 1000 + bonus * 100;
        }
        System.out.println(award);
    }

    private static boolean checkSameThree() {
        return A == B && C == B;
    }

    private static boolean checkAllDifferent() {
        return A != B && B != C && C != A;
    }
}