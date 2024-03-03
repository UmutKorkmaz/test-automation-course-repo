package org.example.seleniumcssselector;

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
        $$("button").get(3).click();
        $("#dynamicClickMessage").shouldHave(text("You have done a dynamic click"));
    }

    @Test
    public void addAndEditLastWebTableRecord() {
        open("/webtables");
        $(By.cssSelector("#addNewRecordButton")).click(); // Click on the "Add" button

        // Fill in the form to add a new record
        $(By.cssSelector("#firstName")).setValue("Umut");
        $(By.cssSelector("#lastName")).setValue("Korkmaz");
        $(By.cssSelector("#userEmail")).setValue("umutkorkmaz@outlook.com.tr");
        $(By.cssSelector("#age")).setValue("30");
        $(By.cssSelector("#salary")).setValue("5000");
        $(By.cssSelector("#department")).setValue("IT");
        $(By.cssSelector("#submit")).click(); // Submit the new record

        // Assume the record is added; now click on the edit button of the last record
        // Using ":last-child" to select the last edit button in the table
        $$(By.cssSelector(".action-buttons span[title='Edit']")).last().click();

        // Now editing the last added record
        // Clearing and setting new values in the fields
        $(By.cssSelector("#firstName")).clear();
        $(By.cssSelector("#firstName")).setValue("Umut");
        $(By.cssSelector("#lastName")).clear();
        $(By.cssSelector("#lastName")).setValue("Korkmaz");
        $(By.cssSelector("#userEmail")).clear();
        $(By.cssSelector("#userEmail")).setValue("umutkorkmaz@outlook.com.tr");
        $(By.cssSelector("#age")).clear();
        $(By.cssSelector("#age")).setValue("35");
        $(By.cssSelector("#salary")).clear();
        $(By.cssSelector("#salary")).setValue("6000");
        $(By.cssSelector("#department")).clear();
        $(By.cssSelector("#department")).setValue("HR");
        $(By.cssSelector("#submit")).click(); // Submit the edited record
    }

}
