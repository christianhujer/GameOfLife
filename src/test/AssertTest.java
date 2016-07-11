import org.junit.Test;

public class AssertTest {

    @Test
    public void testAssertEqualsAndHashcode() {
        Assert.assertEqualsAndHashcode("foo", "foo");
        Assert.assertNotEqualsAndHashcode("foo", "bar");
    }

    @Test(expected = AssertionError.class)
    public void testAssertEqualsAndHashcodeFailure() {
        Assert.assertEqualsAndHashcode("foo", "bar");
    }

    @Test(expected = AssertionError.class)
    public void testAssertNotEqualsAndHashcodeFailure() {
        Assert.assertNotEqualsAndHashcode("foo", "foo");
    }
}
