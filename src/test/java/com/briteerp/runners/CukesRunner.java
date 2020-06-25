package com.briteerp.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        plugin = {"json:target/cucumber.json",
//                "html:target/failed-html-report",},
        features ={"src\\test\\resources\\features"} ,
        glue = {"com\\briteerp\\stepdefinitions"},

        dryRun = false,
        tags = "@login"

)

public class CukesRunner {
}
