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

    public boolean isPalindrome(String word) {
        // turn the String into a Deque
        Deque<Character> myDeque = wordToDeque(word);

        boolean passed = true;
        // loop through the deque and compare it
        while (myDeque.size() > 1) {
            // pop item from front and back and compare
            passed = myDeque.removeFirst() == myDeque.removeLast();
            if (!passed) {
                break;
            }
        }
        return passed;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> myDeque = wordToDeque(word);

        boolean passed = true;

        while (myDeque.size() > 1) {
            passed = cc.equalChars(myDeque.removeFirst(), myDeque.removeLast());
            if (!passed) {
                break;
            }
        }
        return passed;
    }
}
