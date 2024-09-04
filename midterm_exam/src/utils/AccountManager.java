package utils;

public class AccountManager {
    public static String USERNAME = "duc";
    public static String PASSWORD = "123456";
    public static String EMAIL = "dinhtrongduc@gmail.com";

    public AccountManager() {
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static void setUSERNAME(String USERNAME) {
        AccountManager.USERNAME = USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        AccountManager.PASSWORD = PASSWORD;
    }

    public static String getEMAIL() {
        return EMAIL;
    }

    public static void setEMAIL(String EMAIL) {
        AccountManager.EMAIL = EMAIL;
    }
}
