package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className ="div[class='fallbackTitle__1zAZ8ALf']")
	WebElement text;
	
	@FindBy(xpath = "//*[@id='searchInDocument']/div/div/div[1]/div/div/div[4]/div[1]/div/div")
	WebElement txtKeyword;
	
	@FindBy(xpath="//*[@id='root']/div/div/div[2]/div[3]/div/div/div[2]/div/div[2]/div[1]/div/div[3]/div/div[1]/div/div")
	WebElement scroll;
				 
	@FindBy(xpath="//span[contains(text(),'Headquartered in New York City,')]")
			WebElement link1 ;
	@FindBy(xpath="//span[contains(text(),'alphasense@vividand.co')]")
	WebElement link ;

	
	@FindBy(id ="content-1")
	WebElement frame;
	
		public WebElement verifyPageLoaded() {
		return text;
	}
	public WebElement enterKeywordsToBeSearched() {
		return txtKeyword;
	}
	public WebElement scrollDown() {
		return scroll;
	}

	public void clickOnLink() {
		 link.click();
		 
	}
	
	public WebElement iFrame() {
		return frame;
	}

	public String getLinkText() {
		String text = link.getText();
		return text;
	}
	public String getHighlightedColor() {
		return link.getCssValue("color");
	}
	
	public String getBackgroundColor() {
		return link.getCssValue("background-color");
	}
	}
