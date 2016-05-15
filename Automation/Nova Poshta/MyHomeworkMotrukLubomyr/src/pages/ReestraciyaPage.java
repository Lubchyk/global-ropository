package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import libs.WebElementsOnPage;
import static libs.ConfigData.getCfgValue;

public class ReestraciyaPage {

	WebDriver driver;
	Logger log;
	WebElementsOnPage webElementsOnPage;

public ReestraciyaPage(WebDriver driver ) {
	this.driver = driver;
	log = Logger.getLogger(getClass());
	webElementsOnPage = new WebElementsOnPage(driver);
}
public boolean openReestraciyaPage() {
	webElementsOnPage.openBrowser();
	try {
		webElementsOnPage.openUrl(getCfgValue("MAIN_URL") + "registration");
		return true;
	} catch (Exception e) {
		log.error("Can not work with config.properties");
		return false;
	}
}
public void closePageAndBrowser() {
	webElementsOnPage.closeBrowserAndUrl();
}
public boolean selecktValueFromDD( String valueFromTC) {
	return webElementsOnPage.selecktValueFromDD("Reestraciya.Misto.Value1", valueFromTC);
}
public boolean clickOnElementMistoValue() {
	return webElementsOnPage.clickOnElement("Reestraciya.Misto.Value");
}
public boolean clickOnElementMisto() {
	return webElementsOnPage.clickOnElement("Reestraciya.Misto.Value1");
}
public boolean typeTextToInputPrisvushche(String text) {
	return webElementsOnPage.typeTextToInput("Reestraciya.Prisvushche.input", text);
}
public boolean typeTextToInputImya(String text) {
	return webElementsOnPage.typeTextToInput("Reestraciya.Imya.input", text);
}
public boolean typeTextToInputPoBatkovi(String text) {
	return webElementsOnPage.typeTextToInput("Reestraciya.PoBatkovi.input", text);
}
public boolean typeTextToInputPhone(String text) {
	return webElementsOnPage.typeTextToInput("Reestraciya.Telephon.input", text);
}
public boolean typeTextToInputEmail(String text ) {
	return webElementsOnPage.typeTextToInput("Reestraciya.Email.input", text);
}
public boolean clickOnElementStat() {
	return webElementsOnPage.clickOnElement("Reestraciya.Stat.DropList");
}
public boolean clickOnElementStatValue() {
	return webElementsOnPage.clickOnElement("Reestraciya.Stat.Value");
}
public boolean clickOnBaton() {
	return webElementsOnPage.clickOnBatton("Reestraciya.Zareestruvatusya.input");
}
public boolean checkValidationMessage() {
	return webElementsOnPage.findElement("REZ.Reestraciya.block");
}
}


