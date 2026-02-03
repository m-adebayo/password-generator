package uk.ac.gold.madeb001.passwordApp.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {

    @Test
    void generatedPasswordHasCorrectLength() {
        Generator generator = new Generator();

        int length = 12;
        String password = generator.generate(length);

        assertNotNull(password, "Password should not be null");
        assertEquals(length, password.length(), "Password length should match requested length");
    }
}
