package general;

public class EnvGlobals {

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class UserData {
        public static String email;
        public static String password;
    }

    public static class AppData {
        public static String on = " ON";
        public static String off = "OFF";
        public static String dropDownSelectedData = "Appium is awesome";
        public static String msgSignup = "You successfully signed up!";
        public static String msgLogin = "You are logged in!";
        public static String msgActiveBtn = "This button is active";
        public static String msgGreeting = "Congratulations";
        public static String msgHiddenImg = "You found me!!!";
    }

    public static class WebData {
        public static String url = "github.com/webdriverio";
    }



}
