import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.

    // This is a non-instance field ("static")
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindromeTrue() {
        String word1 = "kayak";

        // Edge case, word of length 0 or 1
        String word2 = "";
        String word3 = "a";

        boolean passed = palindrome.isPalindrome(word2)
                && palindrome.isPalindrome(word3)
                && palindrome.isPalindrome(word1);
        assertTrue(passed);
    }

    @Test
    public void testIsPalindromeFalse() {
        String word = "zootomy";
        assertFalse(palindrome.isPalindrome(word));
    }

    @Test
    public void testPalindrome() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertFalse(palindrome.isPalindrome("Flake", cc));
        assertTrue(palindrome.isPalindrome("&lak%", cc));
        assertFalse(palindrome.isPalindrome("racecar", cc));
    }
}

