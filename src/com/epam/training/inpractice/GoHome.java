package com.epam.training.inpractice;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

/**
 * Class to calculate when to go home.
 */
public class GoHome {

    private static final String TIME_END = "time.end";
    private static final String TIME_INPUT_FORMAT = "time.input.format";
    private static final String TIME_OUTPUT_FORMAT = "time.output.format";

    static Printer printer = new PrettyConsoleService();
    static Properties props;

    /**
     * Main method
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("name"));

        props = new Properties();
        props.load(GoHome.class.getResourceAsStream("/gohome.properties"));
        LocalTime now = LocalTime.now();
        timeTo(now);

    }

    private static void timeTo(LocalTime now) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(props.getProperty(TIME_INPUT_FORMAT));

        LocalTime end = LocalTime.parse(props.getProperty(TIME_END), dateTimeFormatter);

        // System.out.println(now);
        // System.out.println(end);

        long between = ChronoUnit.MINUTES.between(now, end);

        // @formatter:off
        DateTimeFormatter 
            outFormat = DateTimeFormatter.ofPattern(props.getProperty(TIME_OUTPUT_FORMAT));
        // @formatter:on
        printer.print(now.format(outFormat), end.format(outFormat), between);

    }

}
