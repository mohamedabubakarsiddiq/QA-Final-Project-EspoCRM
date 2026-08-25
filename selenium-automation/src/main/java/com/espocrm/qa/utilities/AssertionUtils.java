package com.espocrm.qa.utilities;

import org.testng.Assert;

public final class AssertionUtils {

    private AssertionUtils() {
        // Prevent object creation
    }

    public static void assertTrue(
            boolean condition,
            String message) {

        Assert.assertTrue(condition, message);
    }

    public static void assertFalse(
            boolean condition,
            String message) {

        Assert.assertFalse(condition, message);
    }

    public static void assertEquals(
            String actual,
            String expected,
            String message) {

        Assert.assertEquals(actual, expected, message);
    }

    public static void assertNotNull(
            Object actual,
            String message) {

        Assert.assertNotNull(actual, message);
    }
}