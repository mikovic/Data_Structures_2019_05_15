public class CountDown {

    public static void main(String[] args) {
        int n = 5;
//        countdownLoop(n);
        countdownRec(n);
    }

    private static void countdownRec(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        countdownRec(--n);
    }

    private static void countdownLoop(int n) {
        while (n > 0) {
            System.out.println(n);
            n--;
        }
    }
}
