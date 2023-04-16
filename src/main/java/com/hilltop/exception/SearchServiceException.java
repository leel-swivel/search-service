package com.hilltop.exception;

/**
 * SearchServiceException
 */
public class SearchServiceException extends RuntimeException {

    /**
     * BaseComponentException Exception with error message.
     *
     * @param errorMessage error message
     */
    public SearchServiceException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Authentication Exception with error message and throwable error
     *
     * @param errorMessage error message
     * @param error        error
     */
    public SearchServiceException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }

}