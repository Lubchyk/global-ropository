package pages;

import static libs.ConfigData.getCfgValue;
import libs.WebElementsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ForgotYourPassword {
	WebDriver driver;
	Logger log;
	WebElementsOnPage webElementsOnPage;
	
	public ForgotYourPassword(WebDriver driver) {
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
	public boolean clickOnButtonKabinet() {
		return webElementsOnPage.clickButton("Kabinet.Button");	
	}
	public boolean typeTextInToInputLogin(String Login) {
		return webElementsOnPage.typeTextInToInput("Kabinet.Login.Input", Login);
	}
	public boolean typeTextInToInputPassword(String Password) {
		return webElementsOnPage.typeTextInToInput("Kabinet.Password.Input", Password);
	}
	public boolean clickOnButtonVoiti() {
		return webElementsOnPage.clickButton("Kabinet.Button.Voiti");
	}
	public boolean typeTextInToInputRecoverLogin(String RecoverLogin) {
		return webElementsOnPage.typeTextInToInput("Search.Input.RecoverLogin", RecoverLogin);
	}
	public boolean clickOnButtonNapomnit() {
		return webElementsOnPage.clickButton("Search.Button.Napomnit");	
	}
	public boolean isElementPresentOnPage() {
		return webElementsOnPage.isElementPresentOnPage("Search.Password");	
	}
	
}
