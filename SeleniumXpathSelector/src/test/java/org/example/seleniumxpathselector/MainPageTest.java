package org.example.seleniumxpathselector;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.baseUrl = "https://demoqa.com";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void clickThirdButton() {
        open("/buttons");
        sleep(2000);
        $x("(//button)[4]").click();
        $("#dynamicClickMessage").shouldHave(text("You have done a dynamic click"));
    }

    // The addAndEditLastWebTableRecord method remains unchanged as the focus is on converting only the clickThirdButton method.
    @Test
    public void addAndEditLastWebTableRecord() {
        open("/webtables");

        // Click on the "Add" button using XPath
        $(By.xpath("//button[@id='addNewRecordButton']")).click();

        // Fill in the form to add a new record using XPath
        $(By.xpath("//input[@id='firstName']")).setValue("Umut");
        $(By.xpath("//input[@id='lastName']")).setValue("Korkmaz");
        $(By.xpath("//input[@id='userEmail']")).setValue("umutkorkmaz@outlook.com.tr");
        $(By.xpath("//input[@id='age']")).setValue("30");
        $(By.xpath("//input[@id='salary']")).setValue("5000");
        $(By.xpath("//input[@id='department']")).setValue("IT");

        // Submit the new record using XPath
        $(By.xpath("//button[@id='submit']")).click();

        // Wait until the edit buttons are visible and click the edit button of the last record using XPath
        // Assuming edit buttons have a common class attribute and finding the last one
        var editButtons = $$x("//span[@title='Edit']");
        editButtons.last().click();

        // Now editing the last added record using XPath
        // Clearing existing values and setting new values in the fields
        $(By.xpath("//input[@id='firstName']")).clear();
        $(By.xpath("//input[@id='firstName']")).setValue("Umut");
        $(By.xpath("//input[@id='lastName']")).clear();
        $(By.xpath("//input[@id='lastName']")).setValue("Korkmaz");
        $(By.xpath("//input[@id='userEmail']")).clear();
        $(By.xpath("//input[@id='userEmail']")).setValue("umutkorkmaz@outlook.com.tr");
        $(By.xpath("//input[@id='age']")).clear();
        $(By.xpath("//input[@id='age']")).setValue("35");
        $(By.xpath("//input[@id='salary']")).clear();
        $(By.xpath("//input[@id='salary']")).setValue("6000");
        $(By.xpath("//input[@id='department']")).clear();
        $(By.xpath("//input[@id='department']")).setValue("HR");

        // Submit the edited record using XPath
        $(By.xpath("//button[@id='submit']")).click();
    }

}
