package test.java.com.calculator.retirement;

import main.java.com.calculator.retirement.Male;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class MaleTest {

    @Test
    public void whenCalculateRetirementYears_thenCorrectYearsReturned() {
        Male male = new Male("John", "Doe", LocalDate.of(1980, 1, 1));
        int currentYear = LocalDate.now().getYear();
        int expectedYears = 65 - (currentYear - 1980);
        assertEquals(expectedYears, male.calculateRetirementYears());
    }
}
