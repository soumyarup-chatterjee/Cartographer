package com.cartographer.xml.mapping;

import com.cartographer.activity.ActivityType;
import com.cartographer.exception.CGException;
import com.cartographer.exception.CGExceptionFactory;

public abstract class Mapper {
    private final CGException mappingExceptionHandler;

    public Mapper() {
        this.mappingExceptionHandler = CGExceptionFactory.newInstance(ActivityType.MAPPING);
    }

    public abstract void map(Object input, Object output);

    public abstract void map(Object input, Object[] output);

    public abstract void map(Object[] input, Object output);

    public abstract void map(Object[] input, Object[] output);

    public CGException getMappingExceptionHandler() {
        return mappingExceptionHandler;
    }
}
