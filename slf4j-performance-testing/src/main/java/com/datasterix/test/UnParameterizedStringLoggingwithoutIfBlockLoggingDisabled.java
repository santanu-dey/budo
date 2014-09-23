package com.datasterix.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by santanudey on 9/15/14.
 */
public class UnParameterizedStringLoggingwithoutIfBlockLoggingDisabled implements  TestLogging{

    Logger logger = LoggerFactory.getLogger(this.getClass());
    String loggingString = "Hello World debug logging without if";

    public void loop(int i) {
        for (int j=0; j<=i; j++) {
            // Log level is set to Error. So debug should not be logged. This is equivalent of logging disabled.
            logger.debug("This is logging unparameterized" + loggingString);
        }
    }

}
