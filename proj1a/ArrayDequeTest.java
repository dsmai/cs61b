import java.lang.reflect.Array;

/** Performs some basic array deque tests. */
public class ArrayDequeTest {
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkEquals(int expected, int actual) {
        return expected == actual;
    }

    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Test fixture to add a few items (front) and remove them from the back
     * checkEmpty after
     */
    public static void addFrontTest() {
        System.out.println("Running addFrontTest...");
        ArrayDeque<Integer> ard = new ArrayDeque<>();
        boolean passed = checkEmpty(true, ard.isEmpty());

        ard.addFirst(0);
        passed = checkEmpty(false, ard.isEmpty()) && passed;

        ard.addFirst(2);
        ard.addFirst(4);

        System.out.println(ard.get(1));

        passed = checkSize(3, ard.size()) && passed;
//        passed = checkEquals(4, ard.getFirst()) && passed;
//        passed = checkEquals(0, ard.getLast()) && passed;

        passed = checkEquals(0, ard.removeLast()) && passed;
        passed = checkSize(2, ard.size()) && passed;
        passed = checkEquals(2, ard.removeLast()) && passed;
        passed = checkEquals(4, ard.removeLast()) && passed;

        passed = checkSize(0, ard.size()) && passed;
        passed = checkEmpty(true, ard.isEmpty()) && passed;

        System.out.println(ard.removeFirst());
        System.out.println(ard.removeLast());

        printTestStatus(passed);
    }

    public static void getTest() {
        ArrayDeque<Integer> ard = new ArrayDeque<>();
        ard.addFirst(0);
        int var1 = ard.get(0);
        int var2 = ard.removeLast();

        ard.addLast(3);
        ard.addFirst(4);
        ard.addFirst(5);
        ard.addLast(6);
        int var3 = ard.get(2);
        int var4 = ard.get(3);

        ard.addFirst(9);
        ard.addFirst(10);
        ard.addLast(11);
        ard.addLast(12);
        ard.addFirst(13);
        ard.addLast(14);
        int var5 = ard.removeLast();
        int var6 = ard.removeLast();
        int var7 = ard.removeLast();
        int var8 = ard.removeLast();
        int var9 = ard.get(2);

        int var10 = ard.removeLast();
        int var11 = ard.removeFirst();
        int var12 = ard.removeFirst();
    }

    // main driver
    public static void main(String[] args) {
//        addFrontTest();
        getTest();
    }
}