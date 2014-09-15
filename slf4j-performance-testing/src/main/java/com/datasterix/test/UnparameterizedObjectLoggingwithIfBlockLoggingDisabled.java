package com.datasterix.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by santanudey on 9/15/14.
 */
public class UnparameterizedObjectLoggingwithIfBlockLoggingDisabled implements TestLogging{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void loop(int i) {
        for (int j=0; j<=i; j++) {
            // Log level is set to Error. So errors should be logged.
            if (logger.isDebugEnabled()) {
                // Here we are logging a constructed object. Significant cycle in constructing the object
                // Log level is set to Error. So debug should not be logged. This is equivalent of logging disabled.
                logger.debug("Object Debug" + (new BigInteger(130, new SecureRandom()).toString(32)));
            }
        }
    }
}
