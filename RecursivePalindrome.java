// Christopher Yonek
// Compute Palindrome (Recursion)

public class RecursivePalindrome {

    public static boolean isPalindrome(String s) {

        return isPalindrome(s, 0, s.length() - 1);

    }

    public static boolean isPalindrome(String s, int low, int high) {

        if (high <= low) // Base case

            return true;

        else if (s.charAt(low) != s.charAt(high)) // Base case

            return false;

        else

            return isPalindrome(s, low + 1, high - 1);

    }

    public static void main(String[] args) {
        String[] palinList = {"I","kk","wow","anna","madam","poppop",
                "racecar", "snellens","evitative","jjiijjiijj","aibohphobia",
                "tattarrattat","lolololololol","ccddccddccddcc","yoyoyoyoyoyoyoy",
                "xxxxxxxxxxxxxxxx","vevevevevevevevev","yyyyyyyyyyyyyyyyyy",
                "zzzzzzzzzzzzzzzzzzz"};
            long startTime = System.nanoTime();
            System.out.print(isPalindrome(palinList[0]) + " ");
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println(elapsedTime);
        }

    }
