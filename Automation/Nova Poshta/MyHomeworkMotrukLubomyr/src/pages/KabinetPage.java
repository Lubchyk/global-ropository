package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import static libs.ConfigData.getCfgValue;
import libs.WebElementsOnPage;

public class KabinetPage {
	
	WebDriver driver;
	Logger log;
	WebElementsOnPage webElementsOnPage;

public KabinetPage(WebDriver driver) {
	this.driver = driver;
	log = Logger.getLogger(getClass());
	webElementsOnPage =new WebElementsOnPage(driver);
}
public boolean openKabinetPage() {
	webElementsOnPage.openBrowser();
	try {
		webElementsOnPage.openUrl(getCfgValue("MAIN_URL"));
		return true;
	} catch (Exception e) {
		log.error("Can not work with config.properties");
		return false;
	}
}
public void closeBrowser() {
	webElementsOnPage.closeBrowserAndUrl();
}
public boolean typeTextToInputLogin(String text) {
	return webElementsOnPage.typeTextToInput("Kabinet.LoginAboEmail.input", text);
}
public boolean clickOnLinkVhod() {
	return webElementsOnPage.clickToLink("General.Vhid.link");	
}
public boolean typeTextToInputPassword(String text) {
	return webElementsOnPage.typeTextToInput("Kabinet.Password.input", text);
}
public boolean clickOnButtonUvity() {
	return webElementsOnPage.clickOnBatton("Kabinet.Uvity.input");	
}
public boolean clickOnLinkNalashtuvanna() {
	return webElementsOnPage.clickToLink("Kabinet.Nalashtuvanna.link");
}
public boolean clickOnCheckboxPhone(boolean status) {
	return webElementsOnPage.checkbox("Kabinet.Nalashtuvanna.Phone.checkbox", status);	
}
public boolean clickOnCheckboxOgoloshenaVartist(boolean status) {
	return webElementsOnPage.checkbox("Kabinet.Nalashtuvanna.OgoloshenaVartist.checkbox", status);
}
public boolean clickOnCheckboxDataPostavku(boolean status) {
	return webElementsOnPage.checkbox("Kabinet.Nalashtuvanna.DataPostavku.checkbox", status);
}
public boolean clickOnButtonPidtverdutu() {
	return webElementsOnPage.clickOnBatton("Kabinet.Nalashtuvanna.Pidtverdutu.button");
}
public boolean findElement() {
	boolean inputPhone;
	boolean inputOgoloshenaVartist;
	boolean inputDataPostavku;
	inputPhone = webElementsOnPage.findElement("Kabinet.Nalashtuvanna.Phone.input");
	inputOgoloshenaVartist = webElementsOnPage.findElement("Kabinet.Nalashtuvanna.OgoloshenaVartist.input");
	inputDataPostavku = webElementsOnPage.findElement("Kabinet.Nalashtuvanna.DataPostavku.input");
	if ((inputPhone == false) && (inputOgoloshenaVartist == false) && (inputDataPostavku == false)) {
		log.info("Test passed");
		return true;
	} else {
		log.info("One or more of the elements found, Test Failed");
		return false;
		}
}
}
