import javax.sql.rowset.serial.SQLInputImpl;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for checking equals. */
	public static boolean checkEquals(int expected, int actual) {
		return expected == actual;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {
		System.out.println("Running add/remove test.");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);
	}

	/** Add 3 items, then do getRecursive, also check getFirst and getLast */
	public static void addGetTest() {
		System.out.println("Running add/get test.");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
		// check empty
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast(20);

		lld1.addLast(30);

		lld1.addLast(40);

		lld1.removeLast();

		lld1.addFirst(5);

//		boolean passedGetFirst = checkEquals(5, lld1.getFirst());
//		boolean passedGetLast = checkEquals(30, lld1.getLast());
		boolean passedGetRecursive = checkEquals(20, lld1.getRecursive(2));
		boolean passedGetRecursiveAnother = checkEquals(20, lld1.getRecursive(2));

		printTestStatus(passed);
//		printTestStatus(passedGetFirst);
//		printTestStatus(passedGetLast);
		printTestStatus(passedGetRecursive);
		printTestStatus(passedGetRecursiveAnother);
	}

//	public static void deepCopyConstructorTest() {
//		LinkedListDeque<Integer> lld1 = new LinkedListDeque<>(10);
//		lld1.addFirst(5);
//		lld1.addLast(15);
//		lld1.addLast(20);
//		LinkedListDeque<Integer> lld2 = new LinkedListDeque<>(lld1);
//
//		// now modify the second lld2
//		lld2.addLast(30);
//		boolean passed = checkEquals(lld1.getFirst(), lld2.getFirst());
//		passed = checkEquals(lld1.get(1), lld2.get(1)) && passed;
//		passed = checkEquals(lld1.get(2), lld2.get(2)) && passed;
//		passed = checkEquals(lld1.get(3), lld2.get(3)) && passed;
//
//		printTestStatus((passed));
//	}

//	public static void deepCopyConstructorTest2() {
//		LinkedListDeque<Pug> lld1 = new LinkedListDeque<>(new Pug());
//		lld1.addLast(new Pug("Bi", 2));
//		lld1.addLast(new Pug("Binh", 3));
//		lld1.addLast(new Pug("Teo", 5));
//		LinkedListDeque<Pug> lld2 = new LinkedListDeque<>(lld1);
//
//		lld2.set(1, new Pug("Harry", 6));
//	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
//		addIsEmptySizeTest();
//		addRemoveTest();
//		addGetTest();
//		deepCopyConstructorTest2();
	}
}
