package com.epam.training.inpractice;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to calculate when to go home.
 */
public class GoHome {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoHome.class);

    private static final String TIME_END = "time.end";
    private static final String TIME_INPUT_FORMAT = "time.input.format";
    private static final String TIME_OUTPUT_FORMAT = "time.output.format";
    private static final String LANGUAGE = "language";

    private static Printer printer = new PrettyConsoleService();
    private static Properties props;
    private static ResourceBundle bundle;

    /**
     * Main method
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        LOGGER.info("Program start params: {}", (Object) args);
        init();

        LocalTime now = LocalTime.now();
        timeTo(now);

        LOGGER.info("Program end");
    }

    private static void init() throws IOException {
        props = new Properties();
        props.load(GoHome.class.getResourceAsStream("/gohome.properties"));

        Locale locale = new Locale(props.getProperty(LANGUAGE));
        bundle = PropertyResourceBundle.getBundle("message", locale);
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
        printer.print(bundle.getString("message"), now.format(outFormat), end.format(outFormat), between);

    }

}
