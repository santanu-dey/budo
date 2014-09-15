package com.datasterix.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by santanudey on 9/15/14.
 */
public class ParameterizedObjectLoggingwithoutIfBlockLoggingEnabled implements TestLogging{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void loop(int i) {
        for (int j=0; j<=i; j++) {
            // Log level is set to Error. So errors should be logged.

                // Here we are logging a constructed object. Significant cycle is spent in constructing the object.
                // Log level is set to Error. This is equivalent of logging enabled.
                logger.error("Object Debug {} without if block", (new BigInteger(130, new SecureRandom()).toString(32)));

        }
    }
}
