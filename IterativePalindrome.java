// Christopher Yonek
// Compute Palindrome (Iteration)

public class IterativePalindrome {
    /*Function that returns true if
    str is a palindrome
     */
    static boolean isPalindrome(String str) {

        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, numChars = str.length() - 1;

        // While there are characters toc compare
        while (i < numChars) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(numChars))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            numChars--;
        }

        // Given string is a palindrome
        return true;
    }

    public static void main(String[] args) {
        String[] palinList = {"I","kk","wow","anna","madam","poppop",
                "racecar", "snellens","evitative","jjiijjiijj","aibohphobia",
                "tattarrattat","lolololololol","ccddccddccddcc","yoyoyoyoyoyoyoy",
                "xxxxxxxxxxxxxxxx","vevevevevevevevev","yyyyyyyyyyyyyyyyyy",
                "zzzzzzzzzzzzzzzzzzz"};
        long startTime = System.nanoTime();
        System.out.print(isPalindrome(palinList[18]) + " ");
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println(elapsedTime);
    }

}

