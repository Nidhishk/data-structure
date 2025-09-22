public class PowerOfFour {
    public static void main(String[] args) {
        int n = 64;
        System.out.println(isPowerOfFour(n));
    }

    private static boolean isPowerOfFour(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 4 == 0) {
            n = n / 4;
        }
        return n == 1;
    }
}
