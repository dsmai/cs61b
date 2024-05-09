import org.junit.Test;
import static org.junit.Assert.*;

public class TestSLList {
    @Test
    public void testAddFirst() {
        SLList myList = new SLList();
        assertEquals(0, myList.getSize());
        myList.addFirst(100);
        assertEquals(1, myList.getSize());
        myList.addFirst(200);
        assertEquals(2, myList.getSize());
    }

    @Test
    public void testGet() {
        SLList myList = new SLList();
        assertEquals(null, myList.getNode(0));
        assertEquals(null, myList.getNode(1));

        myList.addFirst(100);
        assertEquals(100, myList.getItem(0));
        assertEquals(-999, myList.getItem(1));

        myList.addFirst(50);
        assertEquals(50, myList.getItem(0));
        assertEquals(100, myList.getItem(1));

        myList.addFirst(10);
        assertEquals(10, myList.getItem(0));
        assertEquals(50, myList.getItem(1));
        assertEquals(100, myList.getItem(2));
    }

    @Test
    public void testInsert() {
        SLList myList = new SLList();

        myList.insert(10, 0);
        assertEquals(1, myList.getSize());
        assertEquals(10, myList.getItem(0));

        myList.addFirst(5);
        myList.insert(20, 1);
        assertEquals(3, myList.getSize());
        assertEquals(5, myList.getItem(0));
        assertEquals(20, myList.getItem(1));
        assertEquals(10, myList.getItem(2));
        assertEquals(-999, myList.getItem(3));

        myList.insert(100, 3);
    }

    @Test
    public void testReverse() {
        SLList myList = new SLList();
        myList.addFirst(15);
        myList.addFirst(10);
        myList.addFirst(5);
        myList.addLast(100);
        int[] beforeReverse = myList.toArray();
        myList.reverse();
        int[] expected = {100, 15, 10, 5};
//        SLList newList = myList.reverseNonDestructive();
        int[] actual = myList.toArray();
        assertArrayEquals(expected, actual);
    }
}