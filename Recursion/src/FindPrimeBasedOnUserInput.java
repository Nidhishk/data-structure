import java.util.Scanner;

class FindNthPrimeNumber {

    // Function to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Function to find the nth prime number
    public static int findNthPrime(int n) {
        int count = 0;
        int num = 2;  // Starting number to check for prime

        // Loop until we find the nth prime number
        while (true) {
            if (isPrime(num)) {
                count++;
                if (count == n) {
                    return num;  // Return the nth prime number
                }
            }
            num++;  // Move to the next number
        }
    }

    public static void main(String[] args) {
        // Scanner to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the position of the prime number
        System.out.print("Enter the value of n (to find the nth prime number): ");
        int n = scanner.nextInt();

        // Call the function to find the nth prime number and display the result
        int nthPrime = findNthPrime(n);
        System.out.println("The " + n + "th prime number is: " + nthPrime);

        // Close the scanner
        scanner.close();
    }
}
