// Christopher Yonek
// Compute Binary Search (Iteration)

public class IterativeBinarySearch {
   public static int IterativeBinarySearch(int numList[], int index) {
        int l = 0, r = numList.length - 1;
        while (l <= r) {
            int j = l + (r - l) / 2;
            if (numList[j] == index)
                return j;
            if (numList[j] < index)
                l = j + 1;
            else
                r = j - 1;
        }
        return -1;
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
            indexOfArray = IterativeBinarySearch(bigMultiplesOf3Array, arrayTested[i]);
            long elapsedTime = System.nanoTime() - startTime;

            if(indexOfArray>0)
                System.out.println(arrayTested[i] + " was found at index " + indexOfArray + " Time Needed: " + elapsedTime);
            else
                System.out.println(arrayTested[i] + " was not found in the array " + " Time Needed: " + elapsedTime);
        }

    }

}
