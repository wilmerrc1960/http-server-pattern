package co.com.eafit.http.server.test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.HttpStatus;
import org.junit.Test;

public class HttpServerTest {
	
	private static String ENDPOINT_GET_HTTP_SERVER = "http://127.0.0.1:8888";

	@Test
	public void testGetIndex(){
       
		given().
		when().
		get(ENDPOINT_GET_HTTP_SERVER+"/index.html")
		.then().
		statusCode(HttpStatus.SC_OK);
	}
	
	
	@Test
	public void testGetNotFound(){
       
		given().
		when().
		get(ENDPOINT_GET_HTTP_SERVER+"/in")
		.then().
		statusCode(HttpStatus.SC_NOT_FOUND)
		.body(equalTo("<h1>404 Not Found</h1>"));
	}
	
	@Test
	public void testRequestMethodNotImplemented(){
       
		given().
		when().
		post(ENDPOINT_GET_HTTP_SERVER+"/in")
		.then().
		statusCode(501)
		.body(equalTo("<h1>501 Not Implemented</h1>"));
	}

}
