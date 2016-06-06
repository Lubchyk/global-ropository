package pages;

import libs.WebElementsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Korzyna {
	WebDriver driver;
	Logger log;
	WebElementsOnPage webElementsOnPage;
	OwnKabinet ownKabinet;
	
	public Korzyna(WebDriver driver){
		this.driver = driver;
		log = Logger.getLogger(getClass());
		webElementsOnPage = new WebElementsOnPage(driver);
		ownKabinet = new OwnKabinet(driver);
	}
	public boolean openMainUrl(){
		return ownKabinet.openOwnKabinet();
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
	public boolean clickLinkRumyana() {
		return webElementsOnPage.clickLink("MakeUP.Rumyana.link");
	}
	public boolean clickElement() {
		return webElementsOnPage.clickElement("MakeUP.Rumyana");
	}
	public boolean clickElementKupit() {
		return webElementsOnPage.clickElement("MakeUP.Rumyana.Kupit");
	}
	public boolean clickElementProdolzhit() {
		return webElementsOnPage.clickElement("MakeUP.Prodolzhit");
	}
	public boolean clickElementKorzina() {
		return webElementsOnPage.clickElement("MakeUP.Korzina");
	}
	public void closeKabinetPageAndBrowser() {
		webElementsOnPage.closeBrowserAndUrl();
		}
	public boolean moveToElement() {
		return webElementsOnPage.moveToElement("MakeUP.Makeup");
	}
	public boolean moveToElementRummyana() {
		return webElementsOnPage.moveToElement("MakeUP.Rumyana.Move");
	}
	public boolean moveToElementKorzina() {
		return webElementsOnPage.moveToElement("MakeUP.Korzina");
	}
	public boolean getValue() {
		try {
			String tempValue = webElementsOnPage.getValue("MakeUP.Korzina.value");
			int tempVar = Integer.parseInt(tempValue);
			try {
				if (tempVar > 0 ) {
				log.info("test passed");
			} } catch (Exception e) {
				log.error("test fail");
		} return true;
		} catch (Exception e)  {
			log.error("Error on some step ");
			return false;
		}
	}
	public boolean clickElementOchistit() {
		return webElementsOnPage.clickElement("MakeUP.Korzina.ochistit");
		
	}
}
