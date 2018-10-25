package lesson063pageobject;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class StupidValidatorTest {

    @Test
    public void isUsedCredsReturnTrueOnUsedCreds() {
        StupidCredsChecker sv = new StupidCredsChecker(new HashMap<String, String>());
        Assert.assertTrue(sv.isUsedCreds("butorinsasha", "M4Jokshr75Jjj"));
    }

    @Test
    public void isUsedCredsReturnFalseOnUnusedCreds() {
        StupidCredsChecker sv = new StupidCredsChecker(new HashMap<String, String>());
        Assert.assertFalse(sv.isUsedCreds("friend", "qweASD123"));
    }

}
