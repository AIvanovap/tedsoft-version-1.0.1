package net.apispark.webapi.utils;

import java.util.Date;
import org.restlet.engine.util.StringUtils;

public class BindingUtils {

    public static void checkInteger(String value) {
        toInteger(value);
    }

    public static Integer toInteger(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            return null;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid integer value ["
                    + value + "]");
        }
    }

    public static void checkLong(String value) {
        toLong(value);
    }

    public static Long toLong(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            return null;
        }
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid long value [" + value
                    + "]");
        }
    }

    public static void checkDate(String value) {
        toDate(value);
    }

    public static Date toDate(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            return null;
        }
        try {
            return new Date(Long.parseLong(value));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid epoch timestamp ["
                    + value + "]");
        }
    }

    public static void checkDouble(String value) {
        toDouble(value);
    }

    public static Double toDouble(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            return null;
        }
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid double value [" + value
                    + "]");
        }
    }

    public static void checkFloat(String value) {
        toFloat(value);
    }

    public static Float toFloat(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            return null;
        }
        try {
            return Float.parseFloat(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid float value [" + value
                    + "]");
        }
    }

    public static void checkBoolean(String value) {
        toBoolean(value);
    }

    public static Boolean toBoolean(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            return null;
        }
        if (value.equalsIgnoreCase("true")) {
            return true;
        } else if (value.equalsIgnoreCase("false")) {
            return false;
        } else {
            throw new IllegalArgumentException("Invalid boolean value ["
                    + value + "]");
        }
    }
}
