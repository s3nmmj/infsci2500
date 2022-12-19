public class HW1 {
    public static void main(String[] args) {
        int maxNumber = 100000;
        int n = 10000;
        int index = 1;
        while (n <= maxNumber) {
            long start = System.nanoTime();
            int count = numberOfPrimes(n);
            long end = System.nanoTime();
            double elapsedTimeInSecond = (double) (end - start) / 1000000;
            System.out.printf("Step: %d, Number of primes from 2 to %d: %d, Elapsed Time: %.1f ms\n",
                    index, n, count, elapsedTimeInSecond);
            n = n + 10000;
            index++;
        }
    }

    public static int numberOfPrimes(int n) {
        int total = 0;
        for (int i = 0; i <= n; i++) {
            if (isPrime(i)) {
                total++;
            }
        }
        return total;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}