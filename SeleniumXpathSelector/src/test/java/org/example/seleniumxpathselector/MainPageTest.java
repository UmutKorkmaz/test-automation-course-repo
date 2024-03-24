package org.example.seleniumxpathselector;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public static void setupClass() {
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void clickThirdButtonUsingXPath() {
        driver.get("https://demoqa.com/buttons");
        WebElement thirdButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button)[4]")));
        thirdButton.click();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicClickMessage")));
        Assertions.assertTrue(message.getText().contains("You have done a dynamic click"));
    }

    @Test
    public void addAndEditLastWebTableRecordUsingXPath() {
        driver.get("https://demoqa.com/webtables");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='addNewRecordButton']"))).click();

        driver.findElement(By.xpath("//input[@id='firstName']"))
                .sendKeys("Umut");
        driver.findElement(By.xpath("//input[@id='lastName']"))
                .sendKeys("Korkmaz");
        driver.findElement(By.xpath("//input[@id='userEmail']"))
                .sendKeys("umutkorkmaz@outlook.com.tr");
        driver.findElement(By.xpath("//input[@id='age']"))
                .sendKeys("30");
        driver.findElement(By.xpath("//input[@id='salary']"))
                .sendKeys("5000");
        driver.findElement(By.xpath("//input[@id='department']"))
                .sendKeys("IT");
        driver.findElement(By.xpath("//button[@id='submit']"))
                .click();

        WebElement lastEditButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@title='Edit'])[last()]")));
        lastEditButton.click();

        WebElement editedFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));
        editedFirstName.clear();
        editedFirstName.sendKeys("Jane");

        WebElement editedLastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        editedLastName.clear();
        editedLastName.sendKeys("Doe");

        WebElement editedEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
        editedEmail.clear();
        editedEmail.sendKeys("janedoe@example.com");

        WebElement editedAge = driver.findElement(By.xpath("//input[@id='age']"));
        editedAge.clear();
        editedAge.sendKeys("40");

        WebElement editedSalary = driver.findElement(By.xpath("//input[@id='salary']"));
        editedSalary.clear();
        editedSalary.sendKeys("7000");

        WebElement editedDepartment = driver.findElement(By.xpath("//input[@id='department']"));
        editedDepartment.clear();
        editedDepartment.sendKeys("HR");

        driver.findElement(By.xpath("//button[@id='submit']"))
                .click();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            Allure.getLifecycle().addAttachment(
                    "Screenshot on failure", "image/png", "png",
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
            );
            driver.quit();
        }

    }
}
