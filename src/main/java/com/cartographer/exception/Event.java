package com.cartographer.exception;

import jakarta.xml.bind.ValidationEvent;

public class Event extends Throwable {
    private final String message;
    private Severity severity;
    private Throwable cause;
    private String location = null;
    private StackTraceElement[] stackTraceElement;

    public Event(Exception e) {
        this.cause = e.getCause();
        this.stackTraceElement = e.getStackTrace();
        this.message = e.getMessage();
        this.severity = Severity.FATAL_ERROR;
    }

    public Event(Exception e, Severity severity) {
        this.cause = e.getCause();
        this.stackTraceElement = e.getStackTrace();
        this.message = e.getMessage();
        this.severity = severity;
    }

    public Event(ValidationEvent validationEvent) {
        Throwable linkedException = validationEvent.getLinkedException();
        int validationEventSeverity = validationEvent.getSeverity();
        this.message = validationEvent.getMessage();
        this.cause = linkedException;
        this.stackTraceElement = linkedException.getStackTrace();
        int errorRow = validationEvent.getLocator().getLineNumber(), errorCol = validationEvent.getLocator().getColumnNumber();
        this.location = (errorRow != -1 && errorCol != -1) ? "At row: " + errorRow + ", column: " + errorCol : null;
        if (validationEventSeverity == ValidationEvent.FATAL_ERROR)
            this.severity = Severity.FATAL_ERROR;
        else if (validationEventSeverity == ValidationEvent.ERROR)
            this.severity = Severity.ERROR;
        else if (validationEventSeverity == ValidationEvent.WARNING)
            this.severity = Severity.WARNING;
    }

    public Event(String message, Severity severity) {
        this.message = message;
        this.severity = severity;
    }

    public Event(String message) {
        this.message = message;
        this.severity = Severity.FATAL_ERROR;
    }

    public String getMessage() {
        return message;
    }

    public Severity getSeverity() {
        return severity;
    }

    public Throwable getCause() {
        return cause;
    }

    public String getLocation() {
        return this.location;
    }

    public StackTraceElement[] getStackTraceElement() {
        return stackTraceElement;
    }
}
