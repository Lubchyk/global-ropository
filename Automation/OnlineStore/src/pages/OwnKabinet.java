package pages;

import libs.WebElementsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import static libs.ConfigData.getCfgValue;

public class OwnKabinet {
	WebDriver driver;
	Logger log;
	WebElementsOnPage webElementsOnPage;
	
	public OwnKabinet(WebDriver driver){
		this.driver = driver;
		log = Logger.getLogger(getClass());
		webElementsOnPage = new WebElementsOnPage(driver);
	}
	public boolean openOwnKabinet() {
		webElementsOnPage.openBrowser();
		try {
			webElementsOnPage.openUrl(getCfgValue("MAIN_URL"));
			return true;
		} catch (Exception e) {
			log.error("Can not work with Properties " + e);
			return false;
		}
	}
	public void closeKabinetPageAndBrowser() {
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
	public boolean clickButtonKabinetUser() {
		return webElementsOnPage.clickButton("Kabinet.User.Button");	
	}
	public boolean clickOnLinkVyiti() {
		return webElementsOnPage.clickLink("Kabinet.Vyiti.Link");
	}
	public boolean clickKabinetButton() {
		return webElementsOnPage.clickButton("Kabinet.Button");
	}
	public boolean checkButtonVoiti() {
		  return webElementsOnPage.isElementPresentOnPage("Kabinet.Button.Voiti"); 
	}
}
