/** Performs some basic array deque tests. */
public class ArrayDequeTest {
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            return false;
        }
        return true;
    }

    // main driver
    public static void main(String[] args) {
        System.out.println("Testing...");
        ArrayDeque<Integer> ard = new ArrayDeque<>();
        ard.addFirst(5);
        ard.addFirst(7);
        ard.addFirst(9);
        ard.addFirst(11);
//        ard.addFirst(15);
//        ard.addFirst(17);
//        ard.addFirst(19);
//        ard.addFirst(21);
//        ard.addFirst(23);
//        ard.addFirst(25);
//        ard.addFirst(27);
//        ard.addLast(3);
//        ard.addLast(1);
//        ard.addLast(-1);
        ard.addLast(-3);
        ard.addFirst(13);
        ard.addFirst(15);
        ard.addFirst(17);
        ard.addFirst(19);
        ard.addFirst(21);
        ard.addFirst(23);
        ard.addFirst(25);
        ard.addLast(3);
//        ard.addLast(-5);
//        ard.removeLast();
        ard.printDeque();
        System.out.println("Size: " + ard.size());
//        System.out.println("Length: " + ard.getLength());
//        System.out.println("Usage ratio: " + ard.getUsageRatio());
//        System.out.println("nextFirstIndex :" + ard.nextFirst);
//        System.out.println("nextLastIndex :" + ard.nextLast);
//        System.out.println("firstIndex :" + ard.getFirstIndex());
//        System.out.println("First item :" + ard.getFirst());
//        System.out.println("lastIndex :" + ard.getLastIndex());
//        System.out.println("Last item :" + ard.getLast());
        System.out.println("Item first :" + ard.get(0));
        System.out.println("Item 3 :" + ard.get(3));
        System.out.println("Item last :" + ard.get(12));
        System.out.println("Item 13 :" + ard.get(13));
    }
}