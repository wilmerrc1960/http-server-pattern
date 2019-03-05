package co.com.eafit.http.server.test;

import static io.restassured.RestAssured.given;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class HttpServerStepDefinitions {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String ENDPOINT_GET_HTTP_SERVER = "http://127.0.0.1:8888";

    //GET OK
	@Given("^a request http get$")
	public void a_request_http_get(){
		request = given();
	}

	@When("^a user retrieves index$")
	public void a_user_retrieves_index(){
		response = request.when().get(ENDPOINT_GET_HTTP_SERVER+"/index.html");
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("^the status code is (\\d+)$")
	public void verify_status_code_ok(int statusCode){
		response.then().statusCode(statusCode);
	}
	
    //GET NOT_FOUND
	@Given("^a request http get not found$")
	public void a_request_http_get_not_found(){
		request = given();
	}

	@When("^a user retrieves a not found resource$")
	public void a_user_retrieves_not_found(){
		response = request.when().get(ENDPOINT_GET_HTTP_SERVER+"/in.html");
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("^the status code not found is (\\d+)$")
	public void verify_status_code_not_found(int statusCode){
		response.then().statusCode(statusCode);
	}
	
	
    //GET NOT_IMPLEMENTED
	@Given("^a request http different method$")
	public void a_request_http_different_method(){
		request = given();
	}

	@When("^a user retrieves by method not implemented$")
	public void a_user_retrieves_by_method_not_implemented(){
		response = request.when().post(ENDPOINT_GET_HTTP_SERVER+"/index.html");
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("^the status code not_implemented is (\\d+)$")
	public void verify_status_code(int statusCode){
		response.then().statusCode(statusCode);
	}

}
