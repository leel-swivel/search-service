package com.hilltop.controller;

import com.hilltop.configuration.Translator;
import com.hilltop.domain.response.ResponseDto;
import com.hilltop.enums.ResponseStatusType;
import com.hilltop.enums.SuccessResponseStatusType;
import com.hilltop.wrapper.ResponseWrapper;
import com.hilltop.wrapper.SuccessResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Controller {
    protected final Translator translator;

    @Autowired
    public Controller(Translator translator) {
        this.translator = translator;
    }

    /**
     * This method creates the data response for success request.
     *
     * @param responseDto responseDto
     * @return response entity
     */
    protected ResponseEntity<ResponseWrapper> getSuccessResponse(ResponseDto responseDto,
                                                                 SuccessResponseStatusType successResponseStatusType,
                                                                 HttpStatus httpStatus) {

        var successResponseWrapper = new SuccessResponseWrapper(ResponseStatusType.SUCCESS,
                successResponseStatusType, responseDto,
                translator.toLocale(successResponseStatusType.getCodeString(successResponseStatusType.getCode())), httpStatus);
        return new ResponseEntity<>(successResponseWrapper, httpStatus);
    }
}
