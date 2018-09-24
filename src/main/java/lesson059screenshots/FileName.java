package lesson059screenshots;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileName {

    public static final String DATE_PATTERN_001 = "yyyyMMdd-HHmmss";

    public static String dateTimeFileName(String pattern) {
        Date now = new Date(); //instantiate Date object at current time
        SimpleDateFormat sdf = new SimpleDateFormat(); // create SimpleDateFormat object
        sdf.applyPattern(pattern); // apply String pattern parameter
        return sdf.format(now); // formats a Date into a date/time string.
    }

    public static String epochFileName() {
        return String.valueOf(System.currentTimeMillis());
    }
}
