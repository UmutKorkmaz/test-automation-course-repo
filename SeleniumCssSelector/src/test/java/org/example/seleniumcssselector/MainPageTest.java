package org.example.seleniumcssselector;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

@Epic("Selenium CSS Selector Testi")
@Feature("Selenium CSS Selector Testi")
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
    public void clickThirdButtonUsingCSS() {
        driver.get("https://demoqa.com/buttons");
        WebElement thirdButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#3")));
        thirdButton.click();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dynamicClickMessage")));
        Assertions.assertTrue(message.getText().contains("You have done a dynamic click"));
    }

    @Test
    public void addAndEditLastWebTableRecordUsingCSS() {
        driver.get("https://demoqa.com/webtables");
        // Click the "Add" button
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#addNewRecordButton"))).click();

        // Fill the form
        driver.findElement(By.cssSelector("#firstName")).sendKeys("Umut");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Korkmaz");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("umutkorkmaz@outlook.com.tr");
        driver.findElement(By.cssSelector("#age")).sendKeys("30");
        driver.findElement(By.cssSelector("#salary")).sendKeys("5000");
        driver.findElement(By.cssSelector("#department")).sendKeys("IT");
        driver.findElement(By.cssSelector("#submit")).click();

        // Edit the last added record
        WebElement lastEditButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".rt-tr-group:last-child .rt-tr -odd .rt-td:last-child .action-buttons span[title='Edit']")));
        lastEditButton.click();

        // Update the form fields
        WebElement editedFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#firstName")));
        editedFirstName.clear();
        editedFirstName.sendKeys("Jane");

        WebElement editedLastName = driver.findElement(By.cssSelector("#lastName"));
        editedLastName.clear();
        editedLastName.sendKeys("Doe");

        WebElement editedEmail = driver.findElement(By.cssSelector("#userEmail"));
        editedEmail.clear();
        editedEmail.sendKeys("janedoe@example.com");

        WebElement editedAge = driver.findElement(By.cssSelector("#age"));
        editedAge.clear();
        editedAge.sendKeys("40");

        WebElement editedSalary = driver.findElement(By.cssSelector("#salary"));
        editedSalary.clear();
        editedSalary.sendKeys("7000");

        WebElement editedDepartment = driver.findElement(By.cssSelector("#department"));
        editedDepartment.clear();
        editedDepartment.sendKeys("HR");

        driver.findElement(By.cssSelector("#submit")).click();
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            // Take a screenshot at the end of each test
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Final Screenshot", "image/png", new ByteArrayInputStream(screenshot), ".png");

            driver.quit();
        }
    }
}
