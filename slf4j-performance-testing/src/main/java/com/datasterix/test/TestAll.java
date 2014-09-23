package com.datasterix.test;

/**
 * Created by santanudey on 9/15/14.
 */
public class TestAll {

    private final static int warmUpLoop = 10000;
    private final static int executionLoop = 100000;


    public static void main(String[] args)
    {
        ParameterizedStringLoggingwithIfBlockLoggingDisabled testRun01 = new ParameterizedStringLoggingwithIfBlockLoggingDisabled();
        ParameterizedStringLoggingwithoutIfBlockLoggingDisabled testRun02 = new ParameterizedStringLoggingwithoutIfBlockLoggingDisabled();
        ParameterizedStringLoggingwithoutIfBlockLoggingEnabled testRun03 = new ParameterizedStringLoggingwithoutIfBlockLoggingEnabled();
        ParameterizedStringLoggingwithIfBlockLoggingEnabled testRun04 = new ParameterizedStringLoggingwithIfBlockLoggingEnabled();

        UnParameterizedStringLoggingwithoutIfBlockLoggingEnabled testRun06 = new UnParameterizedStringLoggingwithoutIfBlockLoggingEnabled();
        UnParameterizedStringLoggingwithoutIfBlockLoggingDisabled testRun07 = new UnParameterizedStringLoggingwithoutIfBlockLoggingDisabled();


        UnparameterizedObjectLoggingwithIfBlockLoggingDisabled testRun08 = new UnparameterizedObjectLoggingwithIfBlockLoggingDisabled();
        ParameterizedObjectLoggingwithIfBlockLoggingDisabled testRun09 = new ParameterizedObjectLoggingwithIfBlockLoggingDisabled();
        ParameterizedObjectLoggingwithoutIfBlockLoggingDisabled testRun10 = new ParameterizedObjectLoggingwithoutIfBlockLoggingDisabled();
        UnarameterizedObjectLoggingwithoutIfBlockLoggingDisabled testRun11 = new UnarameterizedObjectLoggingwithoutIfBlockLoggingDisabled();


        UnparameterizedObjectLoggingwithIfBlockLoggingEnabled testRun12 = new UnparameterizedObjectLoggingwithIfBlockLoggingEnabled();
        ParameterizedObjectLoggingwithIfBlockLoggingEnabled testRun13 = new ParameterizedObjectLoggingwithIfBlockLoggingEnabled();

        UnparameterizedObjectLoggingwithoutIfBlockLoggingEnabled testRun14 = new UnparameterizedObjectLoggingwithoutIfBlockLoggingEnabled();
        ParameterizedObjectLoggingwithoutIfBlockLoggingEnabled testRun15 = new ParameterizedObjectLoggingwithoutIfBlockLoggingEnabled();

        System.out.println("\nMeasuring performance of static String logging and comparing effect of guarding-if-block");
        System.out.println("********************************************");

        System.out.println("\nInitially Logging is Disabled");
        testRun(testRun01, "Parameterized String Logging with if block, logging disabled");
        testRun(testRun02, "Parameterized String Logging without if block, logging disblaed");


        System.out.println("\nEnable Logging Now");
        System.out.println("********************************************");
        testRun(testRun03, "Parameterized String Logging without if block, logging enabled");
        System.out.println("\nEnable if block");
        testRun(testRun04, "Parameterized String Logging with if block, logging enabled");

        System.out.println("\nUsing Unparameterized Logging Now");
        System.out.println("********************************************");
        System.out.println("\nMeasuring performance of static String logging and comparing effect Un-Parameterized logging");
        testRun(testRun06, "Un-parameterized String Logging without if block, logging enabled");
        System.out.println("\nEnable if block");
        testRun(testRun07, "Un-parameterized String Logging without if block, logging disabled");




        System.out.println("\n\nChecking performance of constructed object logging");
        System.out.println("********************************************");

        System.out.println("\nInitially Logging Disabled");
        testRun(testRun08, "Unparameterized Object Logging with if block, logging disabled");
        testRun(testRun09, "Parameterized Object Logging with if block, logging disabled");
        testRun(testRun10, "Parameterized Object Logging without if block, logging disabled");
        testRun(testRun11, "Unparameterized Object Logging without if block, logging disabled");

        System.out.println("\nEnable Logging now");
        testRun(testRun12, "Unparameterized Object Logging with if block, logging enabled");
        testRun(testRun13, "Parameterized Object Logging with if block, logging enabled");

        System.out.println("\nRemove if block now");

        testRun(testRun14, "Unparameterized Object Logging without if block, logging enabled");
        testRun(testRun15, "Parameterized Object Logging without if block, logging enabled");




    }


    public static void testRun(TestLogging loggingInstance, String testCaseName){

        loggingInstance.loop(warmUpLoop);
        long startTime = System.currentTimeMillis();

        loggingInstance.loop(executionLoop);
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime-startTime;

        System.out.println("Time taken to execute test case: "+testCaseName+": "+ Long.toString(timeElapsed)+" milli seconds");

    }
}
