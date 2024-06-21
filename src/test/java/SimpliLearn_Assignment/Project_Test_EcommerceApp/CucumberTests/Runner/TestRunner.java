package SimpliLearn_Assignment.Project_Test_EcommerceApp.CucumberTests.Runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src\\test\\java\\SimpliLearn_Assignment\\Project_Test_EcommerceApp\\CucumberTests\\Features\\TestCart.feature"},
		glue =  {"SimpliLearn_Assignment\\StepDefinitions"},
		plugin = {"pretty","html:target/cucumber.html"},
		dryRun = false
		
		)



public class TestRunner extends AbstractTestNGCucumberTests{

}
