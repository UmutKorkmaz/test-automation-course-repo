package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SalaryCalculatorTest {

    private static Properties testProperties = new Properties();

    static {
        try {
            // Load the properties file
            testProperties.load(new FileInputStream("test.properties"));
        } catch (IOException e) {
            // Print the stack trace if an exception occurs
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateSalaryFromProperties() {
        // Retrieve the number of working days and the expected salary from the properties file
        int workingDays = Integer.parseInt(testProperties.getProperty("workingDays"));
        int expectedSalary = Integer.parseInt(testProperties.getProperty("expectedSalary"));

        // Assert that the calculated salary is equal to the expected salary
        Assert.assertEquals(SalaryCalculator.calculateSalary(workingDays), expectedSalary);
    }
}
