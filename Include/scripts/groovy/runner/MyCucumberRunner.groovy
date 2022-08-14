package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
plugin = "pretty",
features = "Include/features/Register",
tags = ("@CheckUI"),
glue = "",
monochrome=true
)

public class MyCucumberRunner {}
