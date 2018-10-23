package lesson063pageobject;

import java.util.HashMap;
import java.util.Map;

public class StupidValidator {

//    private static final String USERNAME_PATTERN = "^[A-Za-z0-9][A-Za-z0-9-]*[A-Za-]$";
//    private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
//    private static final String PASSWORD_PATTERN = "^\d{7,72}$";
    private Map<String, String> creds = new HashMap<>();

    public StupidValidator(Map<String, String> creds) {
        this.creds = creds;
        creds.put("butorinsasha", "M4Jokshr75Jjj");
    }


    public boolean isRightCreds(String username, String password) {
        if ((creds.containsKey(username))) {
            if (creds.get(username).equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

//    public boolean isValidUsername(String username) {
//        if (username.matches(USERNAME_PATTERN)) {
//            return true;
//        }
//    }
//
//    public boolean isValidPassword(String password) {
//        if (password.matches(PASSWORD_PATTERN)) {
//            return true;
//        }
//    }
//
//    public boolean isValidEmail(String email) {
//        if (email.matches(EMAIL_PATTERN)) {
//            return true;
//        }
//    }

}
