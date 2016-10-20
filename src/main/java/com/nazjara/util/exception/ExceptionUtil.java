package com.nazjara.util.exception;

/**
 * Created by Administrator on 21.10.2016.
 */
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
