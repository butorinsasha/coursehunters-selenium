package lesson063pageobject;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class StupidValidatorTest {

    @Test
    public void isValidCredsReturnTrueOnValidCreds() {
        StupidValidator sv = new StupidValidator(new HashMap<String, String>());
        Assert.assertTrue(sv.isRightCreds("butorinsasha", "M4Jokshr75Jjj"));
    }

    @Test
    public void isValidCredsReturnFalseOnInvalidCreds() {
        StupidValidator sv = new StupidValidator(new HashMap<String, String>());
        Assert.assertFalse(sv.isRightCreds("friend", "qweASD123"));
    }

}