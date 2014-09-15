package com.datasterix.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by santanudey on 9/15/14.
 */
public class ParameterizedStringLoggingwithIfBlockLoggingEnabled implements TestLogging {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    String loggingString = "Hello World Error String Logging, Logging Enabled";

    public void loop(int i) {
        for (int j=0; j<=i; j++) {
            // Log level is set to Error. So errors should be logged.
            if (logger.isErrorEnabled()) {
                logger.error("{}", loggingString);
            }
        }
    }
}
