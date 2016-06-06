package libs;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static libs.ConfigData.ui;

public class WebElementsOnPage {
	WebDriver driver;
	Logger log;
	WebDriverWait wait;

	public WebElementsOnPage(WebDriver externalDriver){
		driver = externalDriver;
		log = Logger.getLogger(getClass());
		wait = new WebDriverWait(driver, 50);
	}
	public void openBrowser() {
		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.error("Browser can't be opened" + e);
			Assert.fail("Browser was not opened");
		}
	}	
	/**
	 * Method open Url
	 * @param url
	 * @return
	 */	
	public boolean openUrl(String url) {
		try {
			driver.get(url);
			log.info("Url was opened " + url);
			return true;
		} catch (Exception e) {
			log.error("Url can not be opened");
			return false;
		}
	}
	/**
	 * Close browser
	 */
	public void closeBrowserAndUrl(){
		driver.quit();
		log.info("Browser was closed");
	}	
	/**
	 * Metho clear type text in to input
	 * @param LocatorNameFromUIMapping
	 * @param text
	 * @return
	 */
	public boolean typeTextInToInput(String locatorNameFromUIMapping, String text){
		try {
			WebElement tempInput;
			tempInput = driver.findElement(ui(locatorNameFromUIMapping));
			tempInput.clear();
			tempInput.sendKeys(text);
			log.info(text + " was input");
			return true;
		} catch (Exception e) {
			log.error("Text can not be type in input " + e);
			return false;
		}
	}
	public boolean clickButton(String locatorNameFromUIMapping){
		try {
			WebElement button = driver.findElement(ui(locatorNameFromUIMapping));
			button.click();
			log.info("Button was clicked");
			return true;
		} catch (Exception e) {
			log.error("Can not work with element " + e);
			return false;
		}
	}
	public boolean clickLink(String locatorNameFromUIMapping) {
		try {
			WebElement link = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ui(locatorNameFromUIMapping))));
			link.click();
			log.info("Link was clicked");
			return true;
		} catch (Exception e) {
			log.error("Link can not be opened " + e);
			return false;
		}
	}
	public boolean clickElement(String locatorNameFromUIMapping) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(ui(locatorNameFromUIMapping))));
			Thread.sleep(1000);
			element.click();
			log.info("Element was clicked");
			return true;
		} catch (Exception e) {
			log.error("Element can not be opened " + e);
			return false;
		}
	}	
	/**
	 * Method set state to checkbox
	 * @param locatorNameFromUIMapping
	 * @param stateFromTc (ONLY!!! "Check", "Uncheck")
	 * @return
	 */
	public boolean setCheckBoxState(String locatorNameFromUIMapping, String stateFromTc) {
		try {
			WebElement checkBox = driver.findElement(ui(locatorNameFromUIMapping));
			if (checkBox.isSelected() && stateFromTc.equals("Check")) {
				log.info("Checkbox is already selected");
			}else if (checkBox.isSelected() && stateFromTc.equals("Uncheck")) {
				checkBox.click();
				log.info("Checkbox was unselected");
			}else if (!checkBox.isSelected() && stateFromTc.equals("Check")) {
				checkBox.click();
				log.info("Checkbox was selected");
			}else if (!checkBox.isSelected() && stateFromTc.equals("Unckeck")) {
				log.info("Checkbox is already unselected");
			}else {
				log.error(stateFromTc + " is not valid");
				return false;
			}
			return true;	
		} catch (Exception e) {
			log.error("Can not work with checkbox " + e);
			return false;
		}
	}
	/**
	 * Method to work with Dropdown
	 * @param locatorNameFromUIMapping
	 * @param value
	 * @return
	 */
	public boolean selectValueFromDD(String locatorNameFromUIMapping, String value) {
		try {
			WebElement dD = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(ui(locatorNameFromUIMapping))));
			Select elementsFromDD = new Select(dD);
			elementsFromDD.selectByValue(value);
			log.info(value + " was selected in DD");
			return true;
		} catch (Exception e) {
			log.error("Can not work with DropDown " + e);
			return false;
		}
	}
	public boolean isElementPresentOnPage(String locatorFromUIMapping) {
		By method = null;
		try {
			method = ui(locatorFromUIMapping);
			log.info("message was find");
		} catch (Exception e) {
			log.error("Can not work with UIMapping " + e);
			Assert.fail("Can not work with UIMapping");
		}
		try {
			WebElement tempElement = driver.findElement(method);
			log.info("Webelement was find");
			return tempElement.isEnabled() && tempElement.isDisplayed();
		} catch (Exception e) {
			log.info("Webelement not find");
			return false;		
		}
	}
	public boolean openNewTab() {
		try {
			driver.findElement(ui("Registration.Register.Button")).sendKeys(Keys.CONTROL + "t");
			log.info("New tab was open");
			for (String s : driver.getWindowHandles()){
				driver.switchTo().window(s); 
				}
			return true;
		} catch (Exception e) {
			log.error("New tab was not open " + e);
			return false;
		}
	}
	public boolean closeNewTab() {
		try {
			driver.close();
			for (String d : driver.getWindowHandles() ) {
				driver.switchTo().window(d);
				log.info("New tab was close"); 
			}
			return true;
		} catch (Exception e) {
			log.error("New tab can not close " + e);
			return false;
		}
	}
	public String getValue(String locator) {
		try {
			Thread.sleep(1000);
			WebElement tempInput = driver.findElement(ui(locator));
			String tempValue = tempInput.getAttribute("value");
			log.info("Get new value " + tempValue);
			return tempValue;
		} catch (Exception e) {
			log.error("Temp value it is not possible to get");
			return "";
		}
	}
	public boolean moveToElement(String lokator) {
		WebElement element = null;
		try {
			element = driver.findElement(ui(lokator));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			log.info("Element find and move");
			return true;
		} catch (Exception e) {
			log.error("Can not move to element " + e);
			return false;
		}
	}
}





