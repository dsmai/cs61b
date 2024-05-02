public class Palindrome {
    // This method will take in a string
    // and return a deque with each element as characters
    // of the string
    public Deque<Character> wordToDeque(String word) {
        // Create an empty deque
        Deque<Character> charDeque = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            charDeque.addLast(word.charAt(i));
        }
        return charDeque;
    }
}