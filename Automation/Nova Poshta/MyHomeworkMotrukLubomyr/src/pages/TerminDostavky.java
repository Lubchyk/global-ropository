package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import static libs.ConfigData.getCfgValue;
import libs.WebElementsOnPage;

public class TerminDostavky {
	
	WebDriver driver;
	Logger log;
	WebElementsOnPage webElementsOnPage;
	
public  TerminDostavky(WebDriver driver) {
	this.driver = driver;
	log = Logger.getLogger(getClass());
	webElementsOnPage = new WebElementsOnPage(driver);
}
public boolean openTerminDostavkyPage() {
	webElementsOnPage.openBrowser();
	try {
		webElementsOnPage.openUrl(getCfgValue("MAIN_URL") + "onlineorder/estimatedate");
		return true;
	} catch (Exception e) {
		log.error("Can not work with config.properties");
		return false;
	}
}
public boolean vvodDatuVidpravky(String date) {
	return webElementsOnPage.typeTextToInput("TerminDostavky.DataVidpravky.input", date);
}
public boolean clickOnElementTypePoslug() {
	return webElementsOnPage.clickOnElement("TerminDostavky.TypePoslug.Label");	
}
public boolean clickOnElementMistoVidpraunyk() {
	return webElementsOnPage.clickOnElement("TerminDostavky.MistoVidpraunyk.Label");	
}
public boolean clickOnElementMistoOderguvach() {
	return webElementsOnPage.clickOnElement("TerminDostavky.MistoOderguvach.Label");	
}
public boolean typeTextToInputTypePoslug(String text) {
	return webElementsOnPage.typeTextInToInputAndClickValue("TerminDostavky.TypePoslug.input", text, "TerminDostavky.TypePoslug.Value");
}
public boolean typeTextToInputMistoVidpraunyk(String misto) {
	return webElementsOnPage.typeTextInToInputAndClickValue("TerminDostavky.MistoVidpraunyk.input", misto, "TerminDostavky.MistoVidpraunyk.Value");
}
public boolean typeTextToInputMistoOderguvach(String misto) {
	return webElementsOnPage.typeTextInToInputAndClickValue("TerminDostavky.MistoOderguvach.input", misto, "TerminDostavky.MistoOderguvach.Value");
}
public boolean clickOnBattonRozrahuvatyVartist() {
	return webElementsOnPage.clickOnBatton("TerminDostavky.RozrahuvatyRozrahuvatyVartist.input");
}
public boolean checkValidationMessage() {
	return webElementsOnPage.findElement("REZ.TerminDostavky.block");
}
public void closeUrlAndBrovser() {
	webElementsOnPage.closeBrowserAndUrl();	
}
}
