package lesson063pageobject;

import java.util.HashMap;
import java.util.Map;

public class StupidValidator {
    private Map<String, String> creds = new HashMap<>();

    public StupidValidator(Map<String, String> creds) {
        this.creds = creds;
        creds.put("butorinsasha", "M4Jokshr75Jjj");
    }

    public boolean isValidCreds(String username, String password) {
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
}
