# AlphaSenseUIAutomation
This is an example project for doing web automation testing using Selenium, maven, Page object model, BDD -cucumber framework. This project test the search functionality in AlphaSense website.

# Running this example
This example can run in chrome and firefox. Both browser drivers are inside project directory under 'driver' folder. Open feature file -> right click run as cucumber feature

# Prerequisites
This example requires the following softwares to run.

Eclipse
Java 1.7 or above
# Build With
Selenium - Browser Automation Framework Maven - Dependency management

# How to Use
This project can be placed anywhere in the system and can be imported in eclipse. Tester can change the configuration details like

application URL, Browser name under Config/Config.properties

Any other properties can be added in config file and read by ConfigReader.java under src > test > java >ConfigReader It also contains the drivers path according to the browser

# Feature file
Feature file conatins gherkin statements for the project as below

Feature: feature to search text under search keyword

Scenario: Search a string/text in the search keyword and scroll at the end of the page and clicks on last search result and verify the choosen statement highlighted in document viewer.

# Step Definition
Step Definition consist of the method/ actions to be performed by mapping with gherkin statement

# Hooks:

Helps in choosing the browser and load the application.For example

@Before public void setup() throws Exception { driver = baseClass.chooseBrowser(); baseClass.openApplication(driver); } @After public void tearDown() throws Exception { driver.close(); driver.quit(); }

# POM Pages
Page class has been created to hold the webelements and passed to step definition as required.

# Utility file
A separate class file has been created to record the test execution under src > test > java > Utility > ScreenRecorderUtil.java having methods:

screenRecorder.startRecord("Method name"); screenRecorder.stopRecord();

recorded videos are placed under test-recordings folder

# Base Class
Base class hold methods to wait for the element to load and methods to choose browser and load application

 #Test Runner
A java class has been created as 'TestRunner' under src > test > java > StepDefinition > TestRunner.java where the cucumber configuration and options are made.

package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber; import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/resources/features", glue= {"StepDefinition"}, monochrome=true, plugin= {"pretty","junit:target/JUnitReports/report.xml", "json:target/JSONReports/report.json", "html:target/HtmlReports" }, dryRun=true) 
public class TestRunner {

}

Reports are created under the project folder 'target'- Json report, html and junit report

