package de.htw_berlin.fb4.calculator;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger =
            LoggerFactory.getLogger(App.class);
    public static void main(String[] args) { Calculator calculator = new Calculator();
        Options options = new Options();
        options.addOption("op", true, "Operation: add, sub, mul, div"); options.addOption("a", true, "First number"); options.addOption("b", true, "Second number");
        CommandLineParser parser = new DefaultParser(); try {
            CommandLine cmd = parser.parse(options, args);
            String operation = cmd.getOptionValue("op");
            double a = Double.parseDouble(cmd.getOptionValue("a")); double b = Double.parseDouble(cmd.getOptionValue("b"));
            double result;
            switch (operation) {
                case "add":
                    result = calculator.add(a, b); break;
                case "sub":
                    result = calculator.subtract(a, b); break;
                case "mul":
                    result = calculator.multiply(a, b); break;
                case "div":
                    result = calculator.divide(a, b); break;
                default:
                    throw new IllegalArgumentException("Unknown operation: " + operation);
            }
            logger.info("Result: {}", result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); HelpFormatter formatter = new HelpFormatter(); formatter.printHelp("calculator", options);
        } }
}
