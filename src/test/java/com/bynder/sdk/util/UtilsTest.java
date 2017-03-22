/**
 * Copyright (c) 2017 Bynder B.V. All rights reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for full license
 * information.
 */
package com.bynder.sdk.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.security.InvalidParameterException;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Tests the {@link Utils} class methods
 */
public class UtilsTest {

    @Rule
    public TestName testName = new TestName();

    /**
     * Tests that response is correctly converted to a Map.
     */
    @Test
    public void buildMapFromResponseTest() {
        String keyA = "keyA";
        String keyB = "keyB";
        String valueA = "valueA";
        String valueB = "valueB";

        StringBuilder stringBuilder = new StringBuilder(keyA).append(Utils.STR_EQUALS).append(valueA).append(Utils.STR_AND).append(keyB).append(Utils.STR_EQUALS).append(valueB);
        String response = stringBuilder.toString();

        Map<String, String> responseMap = Utils.buildMapFromResponse(response);
        assertNotNull(responseMap);
        assertEquals(valueA, responseMap.get(keyA));
        assertEquals(valueB, responseMap.get(keyB));
    }

    /**
     * Tests that if response has invalid format an exception is thrown.
     */
    @Test(expected = InvalidParameterException.class)
    public void buildMapFromResponseFailTest() {
        String keyA = "keyA";
        String keyB = "keyB";
        String valueA = "valueA";

        StringBuilder stringBuilder = new StringBuilder(keyA).append(Utils.STR_EQUALS).append(valueA).append(Utils.STR_AND).append(keyB).append(Utils.STR_EQUALS);
        String response = stringBuilder.toString();

        Utils.buildMapFromResponse(response);
    }
}
