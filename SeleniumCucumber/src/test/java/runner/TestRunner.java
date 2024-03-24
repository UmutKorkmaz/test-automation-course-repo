package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        monochrome = true
)

@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm")
public class TestRunner {
}
