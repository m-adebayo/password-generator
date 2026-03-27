package uk.ac.gold.madeb001.passwordApp;

import uk.ac.gold.madeb001.passwordApp.utils.Generator;

import java.beans.Transient;

import org.junit.api.Assertions;

public class PassswordAppTest {
    
    private boolean containsSpecial(String password) {
        return password.chars().anyMatch((c -> !Character.isLetterOrDigit(c)));
    }

    @Test
    void passwordWithSpecialFlagContainsSpecialChar() {
        Generator generator = new Generator();
        String password;
        do {
            password = generator.generate(10);
        } while (!containsSpecial(password));
        assertTrue(containsSpecial(password));
    }

    @Test
    void containsSpecialReturnsTrueWhenSpecialPresent() {
        assertTrue(containsSpecial("abc@123"));
    }

    @Test
    void containsSpecialReturnsFalseWhenNoSpecialPresent() {
        assertFalse(containsSpecial("abc123"));
    }
}        
