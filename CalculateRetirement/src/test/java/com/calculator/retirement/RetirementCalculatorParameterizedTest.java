package test.java.com.calculator.retirement;

import main.java.com.calculator.retirement.Female;
import main.java.com.calculator.retirement.Male;
import main.java.com.calculator.retirement.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RetirementCalculatorParameterizedTest {

    private static Collection<Object[]> testData() {
        List<Object[]> testCases = new ArrayList<>();
        String[] dataSet = TestConfig.getProperty("testData").split(";");
        for (String data : dataSet) {
            String[] parts = data.split(",");
            LocalDate birthDate = LocalDate.parse(parts[0]);
            int expectedRetirementAge = Integer.parseInt(parts[1]);
            testCases.add(new Object[]{birthDate, expectedRetirementAge});
        }
        return testCases;
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testRetirementAge(LocalDate birthDate, int expectedRetirementAge) {
        Person person = (birthDate.getYear() == 1980) ? new Male("Test", "Male", birthDate) : new Female("Test", "Female", birthDate);
        assertEquals(expectedRetirementAge, person.calculateRetirementYears());
    }
}