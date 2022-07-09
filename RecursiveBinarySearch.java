// Christopher Yonek
// Compute Binary Search(Recursion)

public class RecursiveBinarySearch {
    public static long recursiveBinarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        return recursiveBinarySearch(list, key, low, high);
    }

    public static long recursiveBinarySearch(int[] list, int key, int low, int high) {
        if (low > high) // The list has been exhausted without a match

            return -low - 1;

        int mid = (low + high) / 2;
        if (key < list[mid])
            return recursiveBinarySearch(list, key, low, mid - 1);
        else if (key == list[mid])
            return mid;

        else
            return recursiveBinarySearch(list, key, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] arrayTested = {13, 64, 23, 75, 44, 22, 14, 64, 43, 13, 11, 54, 16, 45, 79, 73, 9, 88, 33,90}; //Array of numbers
        int[] bigMultiplesOf3Array = new int[1000];
        long indexOfArray;
        bigMultiplesOf3Array[0] = 0; // Initialize starting index of Array
        for (int i = 1; i < bigMultiplesOf3Array.length; i++) // Fill Array in multiples
            bigMultiplesOf3Array[i] = bigMultiplesOf3Array[i - 1] + 3;  // of three (0,3,6,9,...,2997)
        for(int i = 0; i < arrayTested.length; i++){
            long startTime = System.nanoTime();
            indexOfArray = recursiveBinarySearch(bigMultiplesOf3Array, arrayTested[i],0, bigMultiplesOf3Array.length-1);
            long elapsedTime = System.nanoTime() - startTime;

            if(indexOfArray>0)
                System.out.println(arrayTested[i] + " was found at index " + indexOfArray + " Time Needed: " + elapsedTime);
            else
                System.out.println(arrayTested[i] + " was not found in the array " + " Time Needed: " + elapsedTime);
        }

    }
}