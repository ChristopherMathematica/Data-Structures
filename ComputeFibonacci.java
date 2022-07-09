// Christopher Yonek
// Compute Fibbonacci (Recursion)

import java.util.Scanner;
public class ComputeFibonacci {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an index for the Fibonacci number: ");
        int index = input.nextInt();
        long startTime = System.nanoTime();
        System.out.println("Fibonacci number at index " + index + " is " + fib(index));
        long elapsedTime = System.nanoTime() - startTime;
      //  System.out.println(elapsedTime);
    }

    public static long fib(long index) {

        if (index == 0) // Base case

            return 0;

        else if (index == 1) // Base case

            return 1;

        else // Reduction and recursive calls

            return fib(index - 1) + fib(index - 2);

    }

}

