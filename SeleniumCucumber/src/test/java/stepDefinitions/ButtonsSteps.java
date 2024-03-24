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

public class ButtonsSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("the user navigates to the DemoQA Buttons page")
    public void theUserNavigatesToTheDemoQAButtonsPage() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");
    }

    @When("the user clicks on the third button")
    public void theUserClicksOnTheThirdButton() {
        WebElement thirdButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button)[4]")));
        thirdButton.click();
    }

    @Then("the user should see a confirmation message indicating the click")
    public void theUserShouldSeeAConfirmationMessageIndicatingTheClick() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicClickMessage")));
        Assert.assertTrue(message.getText().contains("You have done a dynamic click"));
        driver.quit();
    }
}
