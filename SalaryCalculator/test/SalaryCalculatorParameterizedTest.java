package tests;

public class SalaryCalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = {20, 25, 30}) // Farklı çalışma günleri
    public void testCalculateSalaryWithDifferentInputs(int workingDays) {
        int expectedSalary;
        if (workingDays <= 25) {
            expectedSalary = workingDays * 200;
        } else {
            expectedSalary = (25 * 200) + ((workingDays - 25) * (200 + 1000));
        }
        assertEquals(expectedSalary, SalaryCalculator.calculateSalary(workingDays));
    }
}
