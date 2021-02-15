package com.zerobank.runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json"},
        features = "src/test/resources/features",
        glue = "com/zerobank/stepdefnitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
