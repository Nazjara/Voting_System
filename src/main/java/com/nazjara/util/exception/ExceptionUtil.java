package com.nazjara.util.exception;

public class ExceptionUtil {
    private ExceptionUtil() {
    }

    public static void checkForTheRightTime(boolean rightTime)
    {
        if(!rightTime)
        {
            throw new TimeException("It it too late to vote");
        }
    }
}
