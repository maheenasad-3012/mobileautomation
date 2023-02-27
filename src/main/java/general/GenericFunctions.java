package general;
import org.apache.commons.lang3.RandomStringUtils;

public class GenericFunctions {

    public static String generateRandomAlphaNumericString(int limit) {
        return RandomStringUtils.randomAlphanumeric(limit);
    }

    public static String generateRandomEmail(int limit) {
        return generateRandomAlphaNumericString(limit) + "@email.com";
    }

}
