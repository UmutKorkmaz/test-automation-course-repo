package org.example.seleniumselenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.baseUrl = "https://demoqa.com";
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Test
    public void clickThirdButton() {
        open("/buttons");
        // Assume you need to interact with a specific button - adjust the index accordingly if needed
        $x("(//button)[4]").shouldBe(visible).click();
        $("#dynamicClickMessage").shouldHave(text("You have done a dynamic click"));
    }

    @Test
    public void addAndEditLastWebTableRecord() {
        open("/webtables");

        // Click on the "Add" button
        $(By.xpath("//button[@id='addNewRecordButton']"))
                .shouldBe(visible)
                .click();

        // Fill in the form to add a new record
        $(By.xpath("//input[@id='firstName']"))
                .setValue("Umut");
        $(By.xpath("//input[@id='lastName']"))
                .setValue("Korkmaz");
        $(By.xpath("//input[@id='userEmail']"))
                .setValue("umutkorkmaz@outlook.com.tr");
        $(By.xpath("//input[@id='age']"))
                .setValue("30");
        $(By.xpath("//input[@id='salary']"))
                .setValue("5000");
        $(By.xpath("//input[@id='department']"))
                .setValue("IT");

        // Submit the new record
        $(By.xpath("//button[@id='submit']"))
                .click();

        // Click on the edit button of the last record added
        $$(By.xpath("//span[@title='Edit']"))
                .last()
                .shouldBe(visible)
                .click();

        // Edit the last added record
        $(By.xpath("//input[@id='firstName']"))
                .clear();
        $(By.xpath("//input[@id='firstName']"))
                .setValue("Jane");
        $(By.xpath("//input[@id='lastName']"))
                .clear();
        $(By.xpath("//input[@id='lastName']"))
                .setValue("Doe");
        $(By.xpath("//input[@id='userEmail']"))
                .clear();
        $(By.xpath("//input[@id='userEmail']"))
                .setValue("janedoe@example.com");
        $(By.xpath("//input[@id='age']"))
                .clear();
        $(By.xpath("//input[@id='age']"))
                .setValue("40");
        $(By.xpath("//input[@id='salary']"))
                .clear();
        $(By.xpath("//input[@id='salary']"))
                .setValue("7000");
        $(By.xpath("//input[@id='department']"))
                .clear();
        $(By.xpath("//input[@id='department']"))
                .setValue("HR");

        // Submit the edited record
        $(By.xpath("//button[@id='submit']"))
                .click();
    }
}
