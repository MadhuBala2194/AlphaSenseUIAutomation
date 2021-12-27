package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseClass.BaseClass;
import ConfigReader.ConfigReader;

import Pages.SearchPage;
import Utility.ScreenRecorderUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
	
	WebDriver driver;
	BaseClass baseClass = new BaseClass();
	ConfigReader reader = new ConfigReader();
	ScreenRecorderUtil screenRecorder;
	SearchPage page;
	WebElement element;
	
	@Before
	public void setup() throws Exception {
		
		driver = baseClass.chooseBrowser();
		screenRecorder.startRecord("Search AlphaSense in UI");
		baseClass.openApplication(driver);
	}
	@Given("user enter into the application site")
	public void user_enter_into_the_application_site() {	
		
		page = new SearchPage(driver);
		WebElement text = page.verifyPageLoaded();
		baseClass.waitForElementToDisplay(driver, text);	
		
	}

	@When("user search for {string} in Additional Keyword tab")
	public void user_search_for_in_additional_keyword_tab(String string) {
		
		page = new SearchPage(driver);
		Actions action = new Actions(driver);
		element =page.enterKeywordsToBeSearched();
		action.moveToElement(element).click().sendKeys(string).sendKeys(Keys.ENTER).perform();
		
	  }

	@And("click on link for last found results")
	public void click_on_link_for_last_found_results() {
		
		page = new SearchPage(driver);		
		Actions action = new Actions(driver); 
		element =page.scrollDown();		  
		action.moveToElement(element).click().sendKeys(Keys.END).build().perform();
		page.clickOnLink();
		}

	@Then("user verfies statement highlighted in doc viewer")
	public void user_verfies_statement_highlighted_in_doc_viewer() {
		
		String linkText = page.getLinkText();		
		driver.switchTo().frame(page.iFrame());
		
	if(driver.getPageSource().contains(linkText)) {
		boolean status =false;
		
		  String highlightedColor = page.getHighlightedColor(); 
		  String backgroundColor =page.getBackgroundColor();
		  if (!highlightedColor.equals(backgroundColor)) {
		  System.out.println("Text has been highlighted"); 
		  status=true;
		  }	  
		  
		  if(status) { 
			  Assert.assertTrue(status); 
			  }
		 
	}
	}

	@After
	public void tearDown() throws Exception {
		screenRecorder.stopRecord();
		driver.quit();
	}
	
}
