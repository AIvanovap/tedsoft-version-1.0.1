package net.apispark.webapi.utils;

import org.restlet.data.Status;
import org.restlet.resource.ResourceException;

public class PathVariableUtils {

    public static void checkInteger(String value) {
        toInteger(value);
    }

    public static Integer toInteger(String value) {
        try {
            return BindingUtils.toInteger(value);
        } catch (IllegalArgumentException e) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
    }

    public static void checkLong(String value) {
        toLong(value);
    }

    public static Long toLong(String value) {
        try {
            return BindingUtils.toLong(value);
        } catch (IllegalArgumentException e) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
    }

    public static void checkDate(String value) {
        toDate(value);
    }

    public static Long toDate(String value) {
        try {
            return BindingUtils.toLong(value);
        } catch (IllegalArgumentException e) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
    }

    public static void checkDouble(String value) {
        toDouble(value);
    }

    public static Double toDouble(String value) {
        try {
            return BindingUtils.toDouble(value);
        } catch (IllegalArgumentException e) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
    }

    public static void checkFloat(String value) {
        toFloat(value);
    }

    public static Float toFloat(String value) {
        try {
            return BindingUtils.toFloat(value);
        } catch (IllegalArgumentException e) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
    }

    public static void checkBoolean(String value) {
        toBoolean(value);
    }

    public static Boolean toBoolean(String value) {
        try {
            return BindingUtils.toBoolean(value);
        } catch (IllegalArgumentException e) {
            throw new ResourceException(Status.CLIENT_ERROR_NOT_FOUND);
        }
    }

}
