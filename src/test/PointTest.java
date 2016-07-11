import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PointTest {

    @Test
    public void twoPointsAtSameCoordinatesAreEqual() {
        Assert.assertEqualsAndHashcode(new Point(0, 0), new Point(0, 0));
        Assert.assertNotEqualsAndHashcode(new Point(0, 1), new Point(0, 0));
        Assert.assertNotEqualsAndHashcode(new Point(1, 0), new Point(0, 0));
        Assert.assertNotEqualsAndHashcode(new Point(1, 1), new Point(0, 0));
        Assert.assertEqualsAndHashcode(new Point(1, 1), new Point(1, 1));
    }

    @Test
    public void testOffset() {
        assertEquals(new Point(1, 0), new Point(0, 0).offset(1, 0));
        assertEquals(new Point(0, 1), new Point(0, 0).offset(0, 1));
    }
}
