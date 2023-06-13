package com.cartographer.exception;

import jakarta.xml.bind.ValidationEvent;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class GenericException extends CGException {
    @Override
    public boolean handleEvent(ValidationEvent validationEvent) {
        return false;
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {

    }

    @Override
    public void error(SAXParseException exception) throws SAXException {

    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {

    }
}
