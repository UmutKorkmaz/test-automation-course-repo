package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SalaryCalculatorTest {

    @DataProvider(name = "workingDaysProvider")
    public Object[][] createWorkingDays() {
        return new Object[][] {{20}, {25}, {30}};
    }

    @Test(dataProvider = "workingDaysProvider")
    public void testCalculateSalaryWithDifferentInputs(int workingDays) {
        int expectedSalary;
        if (workingDays <= SalaryCalculator.MIN_DAYS_FOR_BONUS) {
            expectedSalary = workingDays * SalaryCalculator.DAILY_WAGE;
        } else {
            expectedSalary = (SalaryCalculator.MIN_DAYS_FOR_BONUS * SalaryCalculator.DAILY_WAGE) +
                    ((workingDays - SalaryCalculator.MIN_DAYS_FOR_BONUS) *
                            (SalaryCalculator.DAILY_WAGE + SalaryCalculator.BONUS_PER_EXTRA_DAY));
        }
        Assert.assertEquals(SalaryCalculator.calculateSalary(workingDays), expectedSalary);
    }
}
