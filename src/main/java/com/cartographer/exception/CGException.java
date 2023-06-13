package com.cartographer.exception;

import com.cartographer.activity.ActivityType;
import jakarta.xml.bind.ValidationEventHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public abstract class CGException implements ValidationEventHandler, ErrorHandler {
    HashMap<ActivityType, ArrayList<Event>> exceptions = new HashMap<>();

    public void add(Event e, ActivityType type) {
        ArrayList<Event> list = this.exceptions.get(type);
        if (list == null)
            list = new ArrayList<>();
        list.add(e);
        this.exceptions.put(type, list);
    }

    public void add(Event e) {
    }

    public void print() {
        Set<ActivityType> keys = exceptions.keySet();
        for (ActivityType key : keys) {
            ArrayList<Event> events = this.exceptions.get(key);
            for (int i = 0; i < events.size(); i++) {
                if (i == 0)
                    System.out.println(key.toString() + " EXCEPTIONS:");
                System.out.println("\t" + "{\n\t\tMessage: " + events.get(i).getMessage());
                System.out.println("\t\t" + "Severity: " + events.get(i).getSeverity());
                System.out.println("\t\t" + "Cause: " + events.get(i).getCause() + "\n\t}");
                String location = events.get(i).getLocation();
                if (location != null)
                    System.out.println("\t" + events.get(i).getLocation());
            }
        }
    }
}
