package uk.ac.gold.madeb001.passwordApp;

import uk.ac.gold.madeb001.passwordApp.utils.Generator;

public class PasswordApp {

    public static void main(String[] args) {
        int passwordLength = 10;

        Generator generator = new Generator();
        String password = generator.generate(passwordLength);
        
        System.out.println("Generated password: " + password);
    }
}