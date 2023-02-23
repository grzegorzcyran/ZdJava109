package sda.practise.log4j;

import org.apache.log4j.Logger;

public class Log4jDemo {

    private static final Logger LOGGER = Logger.getLogger(Log4jDemo.class);
    public static void main(String[] args) {
        LOGGER.error("Error message");
        LOGGER.warn("Warning message");
        LOGGER.fatal("Fatal error message");
        LOGGER.debug("Debug message");
        LOGGER.info("Info message");
        LOGGER.trace("Trace message");

        if(LOGGER.isDebugEnabled()) {
            //jakaś dodatkowa akcja
        }

        Log4jDemo demo = new Log4jDemo();
        try {
            demo.divide(1, 0);
        } catch (ArithmeticException ex) {
            LOGGER.error("Error during math operation");
            ex.printStackTrace();
        }
    }

    private int divide(int a, int b) {
        LOGGER.info("Trying to divide " + a + " by " + b);
        int i = a / b;
        return i;
    }
}
