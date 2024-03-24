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

    @DataProvider(name = "salaryDataProvider")
    public Object[][] salaryDataProvider() {
        return new Object[][]{
                {Integer.parseInt(testProperties.getProperty("workingDays1")), Integer.parseInt(testProperties.getProperty("expectedSalary1"))},
                {Integer.parseInt(testProperties.getProperty("workingDays2")), Integer.parseInt(testProperties.getProperty("expectedSalary2"))},
                {Integer.parseInt(testProperties.getProperty("workingDays3")), Integer.parseInt(testProperties.getProperty("expectedSalary3"))}
        };
    }

    @Test(dataProvider = "salaryDataProvider")
    public void testCalculateSalaryFromProperties(int workingDays, int expectedSalary) {
        Assert.assertEquals(SalaryCalculator.calculateSalary(workingDays), expectedSalary,
                "Failed calculating salary for " + workingDays + " working days.");
    }
}
