package general;

import org.testng.Assert;

public class CommonAssertions {

    public static void assertTrue(Boolean expected,String comment) {
        Assert.assertTrue(expected,comment);
    }

    public static void assertFalse(Boolean expected,String comment) {
        Assert.assertFalse(expected,comment);
    }

    public static void assertStringEqual(String actual, String expected, String comment) {
        Assert.assertEquals(actual,expected,comment);
    }

    public static void assertIntEqual(int actual, int expected , String comment) {
        Assert.assertEquals(actual,expected,comment);
    }

}
