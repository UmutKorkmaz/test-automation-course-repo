package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SalaryCalculatorTest {

    @DataProvider(name = "workingDaysProviderNoBonus")
    public Object[][] createWorkingDaysNoBonus() {
        return new Object[][] {{5}, {10}, {SalaryCalculator.MIN_DAYS_FOR_BONUS}};
    }

    @DataProvider(name = "workingDaysProviderWithBonus")
    public Object[][] createWorkingDaysWithBonus() {
        return new Object[][] {{SalaryCalculator.MIN_DAYS_FOR_BONUS + 1}, {28}, {30}};
    }

    @Test(dataProvider = "workingDaysProviderNoBonus")
    public void testCalculateSalaryWithoutBonus(int workingDays) {
        int expectedSalary = workingDays * SalaryCalculator.DAILY_WAGE;
        Assert.assertEquals(SalaryCalculator.calculateSalary(workingDays), expectedSalary);
    }

    @Test(dataProvider = "workingDaysProviderWithBonus")
    public void testCalculateSalaryWithBonus(int workingDays) {
        int expectedSalary = (SalaryCalculator.MIN_DAYS_FOR_BONUS * SalaryCalculator.DAILY_WAGE) +
                ((workingDays - SalaryCalculator.MIN_DAYS_FOR_BONUS) * 
                (SalaryCalculator.DAILY_WAGE + SalaryCalculator.BONUS_PER_EXTRA_DAY));
        Assert.assertEquals(SalaryCalculator.calculateSalary(workingDays), expectedSalary);
    }
}
