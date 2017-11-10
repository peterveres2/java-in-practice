package com.epam.training.inpractice;

import java.text.MessageFormat;

public class PrettyConsoleService implements Printer {

    /*
     * (non-Javadoc)
     * 
     * @see com.epam.training.inpractice.Printer#print(java.lang.Object)
     */
    @Override
    public void print(String msg, Object... args) {
        String message = String.format(msg, args);

        System.out.print(MessageFormat.format(msg, args));
    }

}
