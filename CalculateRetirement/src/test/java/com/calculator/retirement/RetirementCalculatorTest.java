package test.java.com.calculator.retirement;

import main.java.com.calculator.retirement.Female;
import main.java.com.calculator.retirement.Male;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class RetirementCalculatorTest {

    @Test
    public void testMaleRetirementAge() {
        String birthDateStr = TestConfig.getProperty("birthDateMale");
        LocalDate birthDate = LocalDate.parse(birthDateStr);
        Male male = new Male("Ahmet", "Yılmaz", birthDate);
        assertEquals(21, male.calculateRetirementYears()); // Assuming the current year is 2024
    }

    @Test
    public void testFemaleRetirementAge() {
        String birthDateStr = TestConfig.getProperty("birthDateFemale");
        LocalDate birthDate = LocalDate.parse(birthDateStr);
        Female female = new Female("Ayşe", "Kara", birthDate);
        assertEquals(26, female.calculateRetirementYears()); // Assuming the current year is 2024
    }
}

