package myrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\JavaPractice\\HERE_QA_TAST\\src\\main\\java\\features\\documentation.feature", glue = {
		"stepdefenations" }, format = { "pretty", "html:test-outout", "json:json_output/cucumber.json",
				"junit:junit_xml/cucumber.xml" }, monochrome = true, strict = true, dryRun = false)
public class TestRunner {

}
