package com.datasterix.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by santanudey on 9/15/14.
 */
public class UnparameterizedObjectLoggingwithoutIfBlockLoggingEnabled implements TestLogging{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void loop(int i) {
        for (int j=0; j<=i; j++) {
            // Log level is set to Error. So errors should be logged.
            // Here we are logging a constrcuted object. Significant cycle in constructung the object
            logger.error("Object Error" + (new BigInteger(130, new SecureRandom()).toString(32)));
        }
    }
}
