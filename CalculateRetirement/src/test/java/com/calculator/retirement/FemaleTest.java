package test.java.com.calculator.retirement;

import main.java.com.calculator.retirement.Female;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class FemaleTest {

    @Test
    public void whenCalculateRetirementYears_thenCorrectYearsReturned() {
        Female female = new Female("Jane", "Doe", LocalDate.of(1990, 1, 1));
        int currentYear = LocalDate.now().getYear();
        int expectedYears = 60 - (currentYear - 1990);
        assertEquals(expectedYears, female.calculateRetirementYears());
    }
}
