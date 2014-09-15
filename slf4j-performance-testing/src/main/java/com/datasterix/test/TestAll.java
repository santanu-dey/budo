package com.datasterix.test;

/**
 * Created by santanudey on 9/15/14.
 */
public class TestAll {

    private final static int warmUpLoop = 10000;
    private final static int executionLoop = 100000;


    public static void main(String[] args)
    {
        ParameterizedStringLoggingwithIfBlockLoggingDisabled testCaseObj1 = new ParameterizedStringLoggingwithIfBlockLoggingDisabled();
        ParameterizedStringLoggingwithoutIfBlockLoggingDisabled testCaseObj2 = new ParameterizedStringLoggingwithoutIfBlockLoggingDisabled();
        ParameterizedStringLoggingwithIfBlockLoggingEnabled testCaseObj3 = new ParameterizedStringLoggingwithIfBlockLoggingEnabled();
        ParameterizedStringLoggingwithoutIfBlockLoggingEnabled testCaseObj4 = new ParameterizedStringLoggingwithoutIfBlockLoggingEnabled();

        ParameterizedObjectLoggingwithIfBlockLoggingEnabled testCaseObj5 = new ParameterizedObjectLoggingwithIfBlockLoggingEnabled();
        UnparameterizedObjectLoggingwithIfBlockLoggingEnabled testCaseObj6 = new UnparameterizedObjectLoggingwithIfBlockLoggingEnabled();
        UnparameterizedObjectLoggingwithIfBlockLoggingDisabled testCaseObj7 = new UnparameterizedObjectLoggingwithIfBlockLoggingDisabled();
        ParameterizedObjectLoggingwithIfBlockLoggingDisabled testCaseObj8 = new ParameterizedObjectLoggingwithIfBlockLoggingDisabled();

        ParameterizedObjectLoggingwithoutIfBlockLoggingDisabled testCaseObj9 = new ParameterizedObjectLoggingwithoutIfBlockLoggingDisabled();
        UnparameterizedObjectLoggingwithoutIfBlockLoggingEnabled testCaseObj10 = new UnparameterizedObjectLoggingwithoutIfBlockLoggingEnabled();

        System.out.println("\nChecking performance of static String logging");
        System.out.println("********************************************");

        System.out.println("\nInitially Logging Disabled");
        testRun(testCaseObj1, "Parameterized String Logging with if block, logging disabled");
        testRun(testCaseObj2, "Parameterized String Logging without if block, logging disblaed");

        System.out.println("\nEnable Logging Now");
        testRun(testCaseObj4, "Parameterized String Logging without if block, logging enabled");
        System.out.println("\nEnable if block");
        testRun(testCaseObj3, "Parameterized String Logging with if block, logging enabled");



        System.out.println("\n\nChecking performance of constructed object logging");
        System.out.println("********************************************");

        System.out.println("\nInitially Logging Disabled");
        testRun(testCaseObj7, "Unparameterized Object Logging with if block, logging disabled");
        testRun(testCaseObj8, "Parameterized Object Logging with if block, logging disabled");

        System.out.println("\nEnable Logging Now");
        testRun(testCaseObj6, "Unparameterized Object Logging with if block, logging enabled");
        testRun(testCaseObj5, "Parameterized Object Logging with if block, logging enabled");

        System.out.println("\nRemove if block");
        testRun(testCaseObj9, "Parameterized Object Logging without if block, logging enabled");
        testRun(testCaseObj10, "Unparameterized Object Logging without if block, logging enabled");




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
