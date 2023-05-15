package com.DCLink.task.exception;

import java.text.MessageFormat;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super(MessageFormat.format("Client with id {0} not exist", id));
    }
}
