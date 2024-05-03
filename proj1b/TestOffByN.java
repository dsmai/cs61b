import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testEqualChars2() {
        assertTrue(offByN.equalChars('a', 'f'));
        assertFalse(offByN.equalChars('h', 'f'));
    }
}
