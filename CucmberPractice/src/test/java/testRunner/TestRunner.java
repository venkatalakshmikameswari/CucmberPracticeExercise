package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featureFiles",tags="@GetBook", glue = "stepDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests {

}
