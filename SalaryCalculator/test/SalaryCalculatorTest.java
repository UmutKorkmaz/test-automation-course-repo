package test;

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
        assertEquals(expectedSalary, SalaryCalculator.calculateSalary(workingDays));
    }
}
