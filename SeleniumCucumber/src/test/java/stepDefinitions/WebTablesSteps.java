package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebTablesSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("the user navigates to the DemoQA WebTables page")
    public void theUserNavigatesToTheDemoQAWebTablesPage() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
    }

    @When("the user adds a new record with details {string}, {string}, {string}, {int}, {int}, {string}")
    public void theUserAddsANewRecordWithDetails(String firstName, String lastName, String email, int age, int salary, String department) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton"))).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
        driver.findElement(By.id("salary")).sendKeys(String.valueOf(salary));
        driver.findElement(By.id("department")).sendKeys(department);
        driver.findElement(By.id("submit")).click();
    }

    @And("the user edits the last record with details {string}, {string}, {string}, {int}, {int}, {string}")
    public void theUserEditsTheLastRecordWithDetails(String firstName, String lastName, String email, int age, int salary, String department) {
        WebElement lastEditButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@title='Edit'])[last()]")));
        lastEditButton.click();

        WebElement editedFirstName = driver.findElement(By.id("firstName"));
        editedFirstName.clear();
        editedFirstName.sendKeys(firstName);

        WebElement editedLastName = driver.findElement(By.id("lastName"));
        editedLastName.clear();
        editedLastName.sendKeys(lastName);

        WebElement editedEmail = driver.findElement(By.id("userEmail"));
        editedEmail.clear();
        editedEmail.sendKeys(email);

        WebElement editedAge = driver.findElement(By.id("age"));
        editedAge.clear();
        editedAge.sendKeys(String.valueOf(age));

        WebElement editedSalary = driver.findElement(By.id("salary"));
        editedSalary.clear();
        editedSalary.sendKeys(String.valueOf(salary));

        WebElement editedDepartment = driver.findElement(By.id("department"));
        editedDepartment.clear();
        editedDepartment.sendKeys(department);

        driver.findElement(By.id("submit")).click();
    }

    @Then("the user should see the edited record with first name {string}")
    public void theUserShouldSeeTheEditedRecordWithFirstName(String expectedFirstName) {
        WebElement firstNameInTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'rt-tr-group')][last()]//div[@class='rt-td'][1]")));
        Assert.assertEquals(expectedFirstName, firstNameInTable.getText());
        driver.quit();
    }
}