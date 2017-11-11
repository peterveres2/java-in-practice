package com.epam.training.inpractice;

import java.text.MessageFormat;

import org.apache.log4j.Logger;

public class PrettyConsoleService implements Printer {

    Logger LOGGER = Logger.getLogger(PrettyConsoleService.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.epam.training.inpractice.Printer#print(java.lang.Object)
     */
    @Override
    public void print(String msg, Object... args) {
        LOGGER.debug("Now I'm writing to the console...");
        String message = String.format(msg, args);

        System.out.print(MessageFormat.format(msg, args));
    }

}
