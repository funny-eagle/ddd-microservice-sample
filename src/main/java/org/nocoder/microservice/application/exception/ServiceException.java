package org.nocoder.microservice.application.exception;

public class ServiceException extends Exception{
    public ServiceException(String message) {
        super(message);
    }
}
