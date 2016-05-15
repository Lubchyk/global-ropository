package libs;

import static libs.ConfigData.ui;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementsOnPage {
	WebDriver driver;
	Logger log;
	WebDriverWait wait;
//	FluentWait wait1;
	
	
public WebElementsOnPage(WebDriver exrernalDriver) {
	driver = exrernalDriver;
	log = Logger.getLogger(getClass());
	wait = new WebDriverWait(driver, 10);	
//	wait1 = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS);
	}
public void openBrowser() {
	try {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.info("Browser was opened");
	} catch (Exception e) {
		log.error("Browser can't be opened " + e);
		Assert.fail("Browser was not opened");
	}
}
public boolean openUrl(String url) {
	try {
		driver.get(url);
		log.info("Url was opened " + url);
		return true;
	} catch (Exception e) {
		log.error("Url cant not be opened");
		Assert.fail("Url can not be opened");
		return false;
	}
}
public void closeBrowserAndUrl() {
	driver.quit();
	log.info("Brovser was closed");
}
public boolean typeTextInToInputAndClickValue(String locator1, String text, String locator2) {
	try {
		WebElement valueFromList;
		WebElement input;
		input = driver.findElement(ui(locator1));
		input.clear();
		input.sendKeys(text);
		valueFromList = driver.findElement(ui(locator2));
		valueFromList.click();
		log.info( "the text " + text + " entered and click");
		return true;
	} catch (Exception e) {
		log.error("Text cant not be type in input " + e);
		return false;
	}
}
public boolean typeTextToInput(String locator, String text) {
	try {
		WebElement input;
		input = driver.findElement(ui(locator));
		input.clear();
		input.sendKeys(text);
		log.info("The text " + text + " was entered");
		return true;
	} catch (Exception e) {
		log.error("The text " + text + " can not be entered");
		return false;
	}
}
public boolean clickOnElement(String locator) {
	try {
		WebElement element = driver.findElement(ui(locator));
		element.click();
		log.info("Element was clicked");
		return true;
	} catch (Exception e) {
		log.error("Can't work with element " + e);
		return false;
	}
}
public boolean clickOnBatton(String locator) {
	try {
		WebElement batton = driver.findElement(ui(locator));
		batton.click();
		log.info("Batton was clicked");
		return true;
	} catch (Exception e) {
		log.error("Can not work with batton " + e);
		return false;
	}
}
public boolean clickToLink(String locator) {
	try {
		WebElement link = driver.findElement(ui(locator));
		link.click();
		log.info("Link was klicked");
		return true;
	} catch (Exception e) {
		log.error("Can't work with link" + e);
		return false;
	}		
}
public boolean checkbox(String locator, boolean status) {
	WebElement checkbox;
	try {
		checkbox = driver.findElement(ui(locator));
		if (checkbox.isSelected() && status == true) {
			log.info("checkbox is already selected");
		}
		else if (checkbox.isSelected() && status == false) {
			checkbox.click();
			log.info("checkbox is selected");
		}
		else if (!checkbox.isSelected() && status == true) {
			checkbox.click();
			log.info("checkbox is seleckted");		
		}
		else if (!checkbox.isSelected() && status == false) {
			log.info("checkbox is olready unselected");
		}
		else {
			log.error(status + " is not valid ");
			return false;
		}
		return true;
	} catch (Exception e) {
		log.error("checkbox is not find " + e);
		return false;
	}
}
public boolean selecktValueFromDD(String locator, String value) {
	try {	
		WebElement dd = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ui(locator))));
		Select newselect = new Select(dd);
		newselect.selectByValue(value);
		log.info(value + " was seleckted in DD");
		return true;
	}
	catch (Exception e){ 
		log.error("DD is not find " + e);
		return false;
	}
}
public boolean findElement(String locatorr ) {
	By metod = null;
	try {
		metod = ui(locatorr);
	} catch (Exception e) {
		log.error("Can't work with UIMapping");
		Assert.fail("Can't work with UIMapping");
	}
	try {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//wait.withTimeout(300, TimeUnit.SECONDS);
		//wait.wait(500000000);
		WebElement tempElement = driver.findElement(metod);
		log.info("Element was find");
		return tempElement.isEnabled() && tempElement.isDisplayed(); 
	} catch (Exception e) {
		log.info("Element was not find");
		return false;
	}
}
}
