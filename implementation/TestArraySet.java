import org.junit.Test;
import static org.junit.Assert.*;

public class TestArraySet {
    static Set<Integer> mySet = new ArraySet<>();

    @Test
    public void testSize() {
        mySet.add(5);
        assertEquals(1, mySet.size());
        assertTrue(mySet.contains(5));
        mySet.add(10);
        assertEquals(2, mySet.size());
        assertTrue(mySet.contains(5) && mySet.contains(10));
    }

    @Test
    public void testResize() {
        ArraySet<Integer> mySet1 = new ArraySet<>();
        mySet1.add(100);
        mySet1.add(200);
        assertEquals(0.5, mySet1.getUsageRatio(), 0.01);
        mySet1.resize(16);
        assertEquals(16, mySet1.getLength());
        assertEquals(0.125, mySet1.getUsageRatio(), 0.01);
        assertTrue(mySet1.contains(100));
        assertTrue(mySet1.contains(200));
    }
}