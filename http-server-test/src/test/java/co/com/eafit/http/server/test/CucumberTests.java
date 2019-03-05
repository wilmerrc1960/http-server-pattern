package co.com.eafit.http.server.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
		glue = {"co.com.eafit.http.server.test"},
		features = {"src/test/resources"})
public class CucumberTests {

}
