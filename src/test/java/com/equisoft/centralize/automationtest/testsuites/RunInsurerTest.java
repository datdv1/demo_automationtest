package com.equisoft.centralize.automationtest.testsuites;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/equisoft/centralize/automationtest/features",
        plugin = {
                "pretty",
                "json:target/cucumber_json_reports/insurer-feature.json",
                "html:target/insurer-feature.html"
        },
        tags = "@Insurer",
        glue = {
                "com.equisoft.centralize.automationtest.infrastructure.driver",
                "com.equisoft.centralize.automationtest.stepDefinitions.login",
                "com.equisoft.centralize.automationtest.stepDefinitions.insurer"
        }
)
public class RunInsurerTest {
}
