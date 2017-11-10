package com.epam.training.inpractice;

public class PrettyConsoleService implements Printer {
    private static final String MESSAGE = "Kedves Péter, Now: %s, End: %s, time to go home in mins: %d.";

    /*
     * (non-Javadoc)
     * 
     * @see com.epam.training.inpractice.Printer#print(java.lang.Object)
     */
    @Override
    public void print(Object... args) {
        System.out.printf(MESSAGE, args);
    }

}
