package com.lbs.test.feature;

import com.lbs.test.configuration.AppConfiguration;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = "pretty",
    features = "src/test/resources",
    glue = {"com.lbs.test.steps", "cucumber.api.spring"})
@ContextConfiguration(classes = AppConfiguration.class)
public class FeatureRunnerTest {
}
