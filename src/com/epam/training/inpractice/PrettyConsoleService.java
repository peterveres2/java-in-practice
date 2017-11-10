package com.epam.training.inpractice;

public class PrettyConsoleService implements Printer {

    /*
     * (non-Javadoc)
     * 
     * @see com.epam.training.inpractice.Printer#print(java.lang.Object)
     */
    @Override
    public void print(String msg, Object... args) {
        System.out.printf(msg, args);
    }

}
