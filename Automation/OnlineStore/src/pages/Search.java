package pages;

import static libs.ConfigData.getCfgValue;
import libs.WebElementsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Search {
	WebDriver driver;
	Logger log;
	WebElementsOnPage webElementsOnPage;
	
	public Search(WebDriver driver) {
		this.driver = driver;
		log = Logger.getLogger(getClass());
		webElementsOnPage = new WebElementsOnPage(driver);
	}
	public boolean openMainPage() {
		webElementsOnPage.openBrowser();
		try {
			webElementsOnPage.openUrl(getCfgValue("MAIN_URL"));
			return true;
		} catch (Exception e) {
			log.error("Can not work with Properties " + e);
			return false;
		}
	}
	public void closeMainPageAndBrowser() {
		webElementsOnPage.closeBrowserAndUrl();
		}
	public boolean typeTextInToInputValue(String Value) {
		return webElementsOnPage.typeTextInToInput("Search.Input", Value);
	}
	public boolean clickOnButtonSearch() {
		return webElementsOnPage.clickButton("Search.Button");	
	}
	public boolean isElementPresentOnPage() {
		return webElementsOnPage.isElementPresentOnPage("Search.Mylo");	
	}
}
