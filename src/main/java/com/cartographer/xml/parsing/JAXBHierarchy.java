package com.cartographer.xml.parsing;

import jakarta.xml.bind.Unmarshaller;

import java.util.ArrayList;
import java.util.HashMap;

public class JAXBHierarchy extends Unmarshaller.Listener {

    private final HashMap<Object, ArrayList<Object>> hierarchy;

    JAXBHierarchy() {
        this.hierarchy = new HashMap<>();
    }

    public HashMap<Object, ArrayList<Object>> getHierarchy() {
        return hierarchy;
    }

    @Override
    public void afterUnmarshal(Object target, Object parent) {
        ArrayList<Object> childList = this.hierarchy.get(parent);
        if (childList == null)
            childList = new ArrayList<>();
        childList.add(target);
        this.hierarchy.put(parent, childList);
        this.hierarchy.putIfAbsent(target, new ArrayList<>());
    }
}

