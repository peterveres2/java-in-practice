package com.epam.training.inpractice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Class to calculate when to go home.
 */
public class GoHome {

    private static final String TIME_END = "17:00:00.000";
    private static final String TIME_INPUT_FORMAT = "HH:mm:ss.nnn";
    private static final String TIME_OUTPUT_FORMAT = "HH:mm";

    static Printer printer = new PrettyConsoleService();

    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(System.getProperty("name"));
        LocalTime now = LocalTime.now();

        timeTo(now);

    }

    private static void timeTo(LocalTime now) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(TIME_INPUT_FORMAT);

        LocalTime end = LocalTime.parse(TIME_END, dateTimeFormatter);

        // System.out.println(now);
        // System.out.println(end);

        long between = ChronoUnit.MINUTES.between(now, end);

        DateTimeFormatter outFormat = DateTimeFormatter.ofPattern(TIME_OUTPUT_FORMAT);
        printer.print(now.format(outFormat), end.format(outFormat), between);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
