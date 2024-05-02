import org.junit.Assert;

public class TestSort {
    public static void testSort() {
        String[] input = {"miu", "is", "a", "pug"};
        String[] expected = {"a", "is", "miu", "pug"};

        // Call the sort method, it will be a static
        // or non-instance method
        Sort.sort(input);

        // checking
        for (int i = 0; i < input.length; i++) {
            if (!input[i].equals(expected[i])) {
                System.out.println("Mismatch in position " + i + ", expected: " + expected[i] + ", but got: " + input[i] + ".");
                break;
            }
        }
    }

    public static void testSortJunit() {
        String[] input = {"miu", "is", "a", "pug"};
        String[] expected = {"a", "is", "miu", "pug"};
        Sort.sort(input);
        Assert.assertArrayEquals(expected, input);

    }

    public static void main(String[] args) {
        testSortJunit();
    }
}