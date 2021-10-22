package com.equisoft.centralize.automationtest.testsuites;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/equisoft/centralize/automationtest/features/Login.feature",
        tags = "@LoginSuccessful",
        plugin = {
                "pretty",
                "json:target/cucumber_json_reports/login-feature.json",
                "html:target/login-feature.html"
        },
        glue = {
                "com.equisoft.centralize.automationtest.infrastructure.driver",
                "com.equisoft.centralize.automationtest.stepDefinitions.login"
        }
)
public class RunLoginTest {
}
