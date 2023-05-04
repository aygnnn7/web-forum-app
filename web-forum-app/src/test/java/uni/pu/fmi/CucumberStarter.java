package uni.pu.fmi;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "src/test/resources/uni/pu/fmi",
					plugin = {"pretty","html:target/cucumber-report.html"})
public class CucumberStarter {
	
}

