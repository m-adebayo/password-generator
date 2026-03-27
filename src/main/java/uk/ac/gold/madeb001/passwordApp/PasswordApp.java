package uk.ac.gold.madeb001.passwordApp;

import uk.ac.gold.madeb001.passwordApp.utils.Generator;
import org.apache.commons.cli.*;


public class PasswordApp {

    public static void main(String[] args) {
        Options options = new Options();

            options.addOption("s","special",false, "Ensure the password contains at least one non-alphanumeric character");
            options.addOption(Option.builder("1")
            .longOpt("length")
            .hasArg()
            .argName("length")
            .desc("Length of password")
            .build());

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e){
            System.err.println("Error" + e.getMessage());
            System.exit(1);
            return;
        }

        int passwordLength = 10;
        if (cmd.hasOption("1")) {
            passwordLength = Integer.parseInt(cmd.getOptionValue("1"));
        }

        Generator generator = new Generator();
        String password = generator.generate(passwordLength);
        if (cmd.hasOption("s")) {
            do {
                password = generator.generate(passwordLength);
            } while (!containsSpecial(password));
        } else {
            password = generator.generate(passwordLength);
        }

        System.out.println("Generated password: " + password);
    }
    
    private static boolean containsSpecial(String password) {
        return password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
    }
}