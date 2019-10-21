package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class) ---for JUnit Runner
@CucumberOptions(features = "src/test/resources/scenarios", 
				tags = {"@tc002"},
				glue = {"gluecode"},
				format = {"pretty", "html:target/cucumber-reports/cucumber-pretty", 
						"json:target/cucumber-reports/cucumber.json"}, 
				plugin = "json:target/cucumber-reports/cucumber.json",
		        monochrome = true
//		        ,dryRun = true
				)

public class CukesRunner extends AbstractTestNGCucumberTests {

}
