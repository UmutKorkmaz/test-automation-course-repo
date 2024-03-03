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
            testProperties.load(new FileInputStream("test.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateSalaryFromProperties() {
        int workingDays = Integer.parseInt(testProperties.getProperty("workingDays"));
        int expectedSalary = Integer.parseInt(testProperties.getProperty("expectedSalary"));
        Assert.assertEquals(SalaryCalculator.calculateSalary(workingDays), expectedSalary);
    }
}
