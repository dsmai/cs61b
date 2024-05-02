import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
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
        String word = "kayak";
        assertTrue(palindrome.isPalindrome(word));
    }

    @Test
    public void testIsPalindromeFalse() {
        String word = "horse";
        assertFalse(palindrome.isPalindrome(word));
    }

    @Test
    public void testIsPalindromeEdge() {
        String word1 = "";
        String word2 = "a";
        assertTrue(palindrome.isPalindrome(word1) && palindrome.isPalindrome(word2));
    }
}
