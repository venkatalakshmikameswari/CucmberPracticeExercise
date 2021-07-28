package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.codehaus.plexus.util.StringUtils;

public class BookStepDefinition {
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	private String url="https://www.googleapis.com/books/v1/volumes";


	@Given("a book exists with an isbn of {long}")
	public void a_book_exists_with_an_isbn_of(long isbn) {
		System.out.println(String.format("isbn : %1$s",isbn));
		request =  given().param("q", "isbn:" + isbn);
		
	}

	@When("a user retrieves the book by isbn")
	public void a_user_retrieves_the_book_by_isbn() {
	   System.out.println("user retrieves the book by isbn");
	   response=request.when().get(url);
	   System.out.println(String.format("response : %1$s",response.asString()));
	}

	@Then("the status code is {int}")
	public void the_status_code_is(int statuscode) {
	    System.out.println("the status code");
	    json=response.then().statusCode(statuscode);
	    System.out.println(String.format("json :%1$s",json));
	}

	@Then("response includes the following")
	public void response_includes_the_following(Map<String,String> responseFields) {
	    System.out.println("response includes the following");
	    for(Map.Entry<String,String> fields : responseFields.entrySet()) {
	    	if(StringUtils.isNumeric(fields.getValue())) {
	    		json.body(fields.getKey(),equalTo(Integer.parseInt(fields.getValue())));
	    	}
	    	else {
	    		json.body(fields.getKey(),equalTo(fields.getValue()));
	    	}
	    }
	}

	@Then("response includes the following in any order")
	public void response_includes_the_following_in_any_order(Map<String,String> responseFields) {
	  System.out.println("response includes the following in any order");
	  for(Map.Entry<String, String> fields : responseFields.entrySet()  ) {
		  if(StringUtils.isNumeric(fields.getValue())) {
			  json.body(fields.getKey(),containsInAnyOrder(Integer.parseInt(fields.getValue())));
		  }
		  else {
			  json.body(fields.getKey(),containsInAnyOrder(fields.getValue()));
		  }
	  }
	}


}