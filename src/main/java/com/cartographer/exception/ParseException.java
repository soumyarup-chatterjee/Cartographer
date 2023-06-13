package com.cartographer.exception;

import com.cartographer.activity.ActivityType;
import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

class ParseException extends CGException implements ValidationEventHandler {

    @Override
    public boolean handleEvent(ValidationEvent validationEvent) {
        this.add(new Event(validationEvent), ActivityType.PARSING);
        return validationEvent.getSeverity() < 2;
    }

    @Override
    public void add(Event e) {
        super.add(e, ActivityType.PARSING);
    }

    @Override
    public void warning(SAXParseException exception) {
        this.add(new Event(exception, Severity.WARNING));
    }

    @Override
    public void error(SAXParseException exception) {
        this.add(new Event(exception, Severity.ERROR));
    }

    @Override
    public void fatalError(SAXParseException exception) {
        this.add(new Event(exception, Severity.FATAL_ERROR));
    }
}
