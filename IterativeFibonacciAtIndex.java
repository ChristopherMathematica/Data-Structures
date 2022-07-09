// Christopher Yonek
// Compute Fibonacci (Iteration)

import java.util.Scanner;
public class IterativeFibonacciAtIndex {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for the Fibonacci number: ");
        int index = input.nextInt();
        long startTime = System.nanoTime();
        System.out.println("Fibonacci number at index " + index + " is " + fibonacciLoop(index));
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println(elapsedTime);
    }

    public static int fibonacciLoop(int numAtEnd) { //use loop
        int secondPrevNum, prevNumber = 0, numberGiven = 1;

        for (int i = 1; i < numAtEnd ; i++) {
            secondPrevNum = prevNumber;
            prevNumber = numberGiven;
            numberGiven = secondPrevNum + prevNumber;
        }
        return numberGiven;
    }
}
