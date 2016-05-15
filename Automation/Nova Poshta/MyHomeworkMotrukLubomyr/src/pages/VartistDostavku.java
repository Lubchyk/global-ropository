package pages;

import static libs.ConfigData.getCfgValue;
import libs.WebElementsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class VartistDostavku {
	
	WebDriver driver;
	Logger log;
	WebElementsOnPage webElementsOnPage;
	
public VartistDostavku (WebDriver driver) {
	this.driver = driver;
	log = Logger.getLogger(getClass());
	webElementsOnPage = new WebElementsOnPage(driver);
}
public boolean OpenVartistDostavku() {
	try {
		webElementsOnPage.openBrowser();
		webElementsOnPage.openUrl(getCfgValue("MAIN_URL") + "delivery"); //  zapisatsya-na-kurs/
		return true;
	} catch (Exception e) {
		log.error("Can not work with config.properties " + e);
		return false;
	}
}
public void closePageAndBrowser() {
	webElementsOnPage.closeBrowserAndUrl();
}
public boolean typeTextToInputMistoVidpravnyk(String misto) {
	return webElementsOnPage.typeTextInToInputAndClickValue("VartistDostavku.MistoVidpraunyk.input", misto, "VartistDostavku.MistoVidpraunyk.Value" );
}
public boolean typeTextToInputMistoOderguvach(String misto) {
	return webElementsOnPage.typeTextInToInputAndClickValue("VartistDostavku.MistoOderguvach.input", misto, "VartistDostavku.MistoOderguvach.Value");
}
public boolean clickOnElementTypePoslug() {
	return webElementsOnPage.clickOnElement("VartistDostavku.TypePoslug");
}
public boolean clickOnElementTypePoslugValue() {
	return webElementsOnPage.clickOnElement("VartistDostavku.TypePoslug.Value");
}
public boolean clickOnElementVydVydprauvlenya() {
	return webElementsOnPage.clickOnElement("VartistDostavku.VydVydprauvlenya");
}
public boolean clickOnElementVydVydprauvlenyaValue() {
	return webElementsOnPage.clickOnElement("VartistDostavku.VydVydprauvlenya.Value");
}
public boolean clickOnElementPoslugaZvorotnyaDostavka() {
	return webElementsOnPage.clickOnElement("VartistDostavku.PoslugaZvorotnyaDostavka");
}
public boolean clickOnElementPoslugaZvorotnyaDostavkaValue() {
	return webElementsOnPage.clickOnElement("VartistDostavku.VydZvorotnoiDostavky.Value");
}
public boolean typeTextToInputOgoloshenaVartist(String text) {
	return webElementsOnPage.typeTextToInput("VartistDostavku.OgoloshenaVartist.input", text);
}
public  boolean putCheckbox(Boolean status) {
	return webElementsOnPage.checkbox("VartistDostavku.PoslugaZvorotnyaDostavka.input", status);
}
public boolean clickOnBattonRozrahuvatyVartyst() {
	return webElementsOnPage.clickOnBatton("VartistDostavku.RozrahuvatyVartyst.input");
}
public boolean checkValidationMessage() {
	return webElementsOnPage.findElement("REZ.RozrahunkovaVartystDostavky.block");
}
public boolean clickOnLinkOchystyt() {
	return webElementsOnPage.clickToLink("VartistDostavku.Ochystyt.input");
}
}
