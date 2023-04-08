package com.example.eidopdrachtnovi.exceptions;



public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException() {

        super();

    }

    public RecordNotFoundException(String message) {

        super(message);

    }

}
