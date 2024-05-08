import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;

public class TestSort {
    @Test
    public void testSort() {
        String[] input = {"miu", "is", "a", "pug"};
        String[] expected = {"a", "is", "miu", "pug"};
        Sort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"miu", "is", "a", "pug"};
        int expected = 2;
        int actual = Sort.findSmallest(input, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSwap() {
        String[] input = {"miu", "is", "a", "pug"};
        int a = 0;
        int b = 2;
        String[] expected = {"a", "is", "miu", "pug"};
        Sort.swap(input, a, b);
        assertArrayEquals(expected, input);
    }
}