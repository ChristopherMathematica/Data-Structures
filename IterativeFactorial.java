// Christopher Yonek
// Compute Factorial (Iteration)

import java.util.Scanner;
public class IterativeFactorial {
        public static void main(String[] args) {
            System.out.print("Enter a non-negative integer: ");
            Scanner userInput = new Scanner(System.in);
            int n = userInput.nextInt();
            long startTime = System.nanoTime();
            System.out.println("Factorial of " + n + " is " + factorial(n));
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println(elapsedTime);
        }
    // Method to find factorial given n
    static long factorial(int n){
        long factorialAns = 1, i;
        for (i = 2; i <= n; i++)
            factorialAns *= i;
        return factorialAns;
    }

}
