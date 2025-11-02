package Basics.Recursion;

class problems {
    public static void main(String[] args) {

        /* Super Basics of Recursion */

        // print name n times
        System.out.println("Printing name 5 times:");
        printName(5, "Sardar");

        // print numbers from 1 to n
        System.out.println("Printing numbers from 1 to 5:");
        printNumbers(5);

        // print numbers from n to 1
        System.out.println("Printing numbers from 5 to 1:");
        printNumbersReverse(5);

        // First n natural numbers sum
        System.out.println("Sum of first 5 natural numbers is: " + naturalSum(10, 0));
        System.out.println("Sum of first 5 natural numbers is: " + naturalSum2(10 ));
        
        // Factorial of n
        System.out.println("Factorial of 5 is: " + factorial(5));

        // Power function (x^n)
        System.out.println("Power of 2^5 is: " + power(2, 5));

        /* Slightly Tricky */

        // Fibonacci series
        fibo(0, 1, 9);

        // Nth Fibonacci number (Using Recursion)
        System.out.println("\nNth Fibonacci number is: " + nthFibo(8));

        // Count digits of a number using recursion
        System.out.println("Count of digits in 12345 is: " + countDigits(12345));

        // Reverse a number using recursion
        System.out.println("Reverse of 1234 is "+ reverse(1234));
    }

    public static void printName(int n, String name) {
        if (n == 0) {
            return;
        }
        System.out.println(name);
        printName(n - 1, name);
    }

    public static void printNumbers(int n) {
        if (n == 0) {
            return;
        }
        printNumbers(n - 1);
        System.out.println(n);
    }

    public static void printNumbersReverse(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNumbersReverse(n - 1);
    }

    public static int naturalSum(int n, int sum) {
        if (n < 1) {
            System.out.println(sum);
            return sum;
        }
        // System.out.println(n + " " + sum);
        return naturalSum(n-1, sum + n);
    }

    public static int naturalSum2(int n) {
        if (n == 1) {
            return 1;
        }
        return n + naturalSum2(n - 1);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int pow = 1;
        pow = x * power(x, n - 1);
        return pow;
    }

    public static void fibo(int a, int b, int n) {
        if (n == 0)
            return;
        System.out.print(a);
        fibo(b, a + b, n - 1);
    }

    public static int nthFibo(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return nthFibo(n - 1) + nthFibo(n - 2);
    }

    public static int countDigits(int n) {
        if (n == 0)
            return 0;
        return 1 + countDigits(n / 10);
    }

    public static int reverse(int n) {
        if (n == 0)
            return 0;
        return (n%10) * (int)Math.pow(10, countDigits(n) - 1) + reverse(n / 10);
    }
}