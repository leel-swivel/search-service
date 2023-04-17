package com.hilltop.wrapper;

import com.hilltop.domain.response.ResponseDto;
import com.hilltop.enums.ResponseStatusType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseWrapperTest {

    @Test
     void Should_validate_constructorAndGetters() {
        ResponseStatusType status = ResponseStatusType.ERROR;
        String message = "Error occurred";
        String displayMessage = "Something went wrong";
        int errorCode = 500;
        ErrorResponseWrapper errorResponseWrapper = new ErrorResponseWrapper(status, message, null, displayMessage, errorCode);
        Assertions.assertEquals(status, errorResponseWrapper.getStatus());
        Assertions.assertEquals(message, errorResponseWrapper.getMessage());
        Assertions.assertEquals(displayMessage, errorResponseWrapper.getDisplayMessage());
        Assertions.assertEquals(errorCode, errorResponseWrapper.getErrorCode());
    }
}