package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
plugin = "pretty",
features = "Include/features/Login",
tags = ("@Login"),
glue = "",
monochrome=true
)

public class LoginRunner {}
