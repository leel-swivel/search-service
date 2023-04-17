package com.hilltop.domain.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RequestDtoTest {
    @Test
    void testIsRequiredAvailable() {
        RequestDto requestDto = new RequestDto() {
            @Override
            public String toLogJson() {
                return null;
            }
            // Empty implementation for testing purposes
        };

        Assertions.assertTrue(requestDto.isRequiredAvailable());
    }

    @Test
    void testIsNonEmpty() {
        RequestDto requestDto = new RequestDto() {
            @Override
            public String toJson() {
                return super.toJson();
            }

            @Override
            public String toLogJson() {
                return null;
            }
            // Empty implementation for testing purposes
        };

        String nonEmptyString = "Non-empty string";
        String emptyString = "";
        String nullString = null;

        Assertions.assertTrue(requestDto.isNonEmpty(nonEmptyString));
        Assertions.assertFalse(requestDto.isNonEmpty(emptyString));
        Assertions.assertFalse(requestDto.isNonEmpty(nullString));
    }
}