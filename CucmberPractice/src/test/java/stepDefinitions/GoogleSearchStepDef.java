package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchStepDef {

	@Given("I open a browser")
	public void i_open_a_browser() {
	  System.out.println("I opened the browser");
	}

	@When("I navigate to google page")
	public void i_navigate_to_google_page() {
	System.out.println("Navigates to google page");
	}

	@Then("I validate the search text field")
	public void i_validate_the_search_text_field() {
	   System.out.println("validate the search text field");
	}
}
