import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Assert {
    public static void assertEqualsAndHashcode(final Object o1, final Object o2) {
        assertEquals(o1, o2);
        assertEquals(o1.hashCode(), o2.hashCode());
    }

    public static void assertNotEqualsAndHashcode(final Object o1, final Object o2) {
        assertNotEquals(o1, o2);
        assertNotEquals(o1.hashCode(), o2.hashCode());
    }
}
