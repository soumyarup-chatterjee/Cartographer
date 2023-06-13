package com.cartographer.exception;

import com.cartographer.activity.ActivityType;

public class CGExceptionFactory {
    public static CGException newInstance(ActivityType type) {
        if (type.compareTo(ActivityType.VALIDATION) == 0)
            return new ValidationException();
        else if (type.compareTo(ActivityType.PARSING) == 0)
            return new ParseException();
        else if (type.compareTo(ActivityType.SERIALIZATION) == 0)
            return new SerializeException();
        //else if (type.compareTo(ActivityType.MAPPING) == 0)
        //    return new MappingException();
        return new GenericException();
    }
}
