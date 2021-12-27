package BaseClass;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

import ConfigReader.ConfigReader;

public class BaseClass {

	ConfigReader reader = new ConfigReader();
	WebDriver driver;

	public WebElement waitForElementToDisplay(WebDriver driver, WebElement element) {

		// Wait<WebDriver> wait= new FluentWait(driver);
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.ignoring(NoSuchElementException.class);

		return element;
	}

	public void scrollToPage(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

public WebDriver chooseBrowser() {
	String browser = reader.getBrowser();
if (browser.equalsIgnoreCase("chrome")) {
	System.setProperty("webdriver.chrome.driver", reader.getDriverPathChrome());
	driver = new ChromeDriver();
		} else {

		System.setProperty("webdriver.gecko.driver", reader.getDriverPathFireFox());
	driver = new FirefoxDriver();
}
return driver;
}

	public void openApplication(WebDriver driver) throws InterruptedException {
		driver.navigate().to(reader.getApplicationUrl());
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
}
}
