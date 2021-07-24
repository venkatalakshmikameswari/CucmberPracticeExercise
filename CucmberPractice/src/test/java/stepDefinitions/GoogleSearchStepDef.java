package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import helpers.BrowserHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchStepDef {
	WebDriver driver;

	@Given("I open a browser")
	public void i_open_a_browser() {
	  System.out.println("I opened the browser.");
	}

	@When("I navigate to google page")
	public void i_navigate_to_google_page() {
		driver = BrowserHelper.startBrowser("chrome","https://www.google.com");
	System.out.println("Navigates to google page.");
	}
	
	@When("I Entered the text in search field")
	public void i_Entered_the_text_in_search_field() {
		// WebElement search=driver.findElement(By.name("q"));
		// search.sendKeys("text");
		 WebElement element=driver.findElement(By.name("q"));
		 element.sendKeys("text");
		 element.submit();
       System.out.println("Entered the text in search");
	}

	@Then("I validate the search text field")
	public void i_validate_the_search_text_field() {
String actualtitle=driver.getTitle();
String expectedtitle="text - Google Search";
		Assert.assertEquals(actualtitle,expectedtitle);
	   System.out.println("validate the search text field.");
	}

	@Given("a web browser is on the Google page")
	public void a_web_browser_is_on_the_Google_page() {
		driver = BrowserHelper.startBrowser("chrome","https://www.google.com");
		System.out.println("web browser is on the Google page");
	}

	@When("the search phrase {string} is entered")
	public void the_search_phrase_is_entered(String input) {
		String str=String.format("%1$s",input);
		WebElement element=driver.findElement(By.name("q"));
		 element.sendKeys(input);
		 element.submit();
      System.out.println("Entered the text in search");
	}

	@Then("results for {string} are shown")
	public void results_for_are_shown(String string) {
	    
	}



}
