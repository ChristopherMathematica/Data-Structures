// Christopher Yonek
// Compute Factorial (Recursion)

import java.util.Scanner;

public class ComputeFactorial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");

        int n = input.nextInt();
        long startTime = System.nanoTime();
        System.out.println("Factorial of " + n + " is " + factorial(n));
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println(elapsedTime);
    }

    public static long factorial(int n) {

        if (n == 0) // Base case

            return 1;

        else

            return n * factorial(n - 1); // Recursive call

    }

}
