package pages;

import libs.WebElementsOnPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import static libs.ConfigData.getCfgValue;

public class KabinetPage {
	WebDriver driver;
	Logger log;
	WebElementsOnPage webElementsOnPage;
	
	public KabinetPage(WebDriver driver){
		this.driver = driver;
		log = Logger.getLogger(getClass());
		webElementsOnPage = new WebElementsOnPage(driver);
	}
	public boolean openKabinetPage() {
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
	public boolean clickOnLinkRegistration() {
		return webElementsOnPage.clickLink("Kabinet.Link.Registration");
	}
	public boolean typeTextInToInputFirstName(String FirstName) {
		return webElementsOnPage.typeTextInToInput("Registration.FirstName.Input", FirstName);
	}
	public boolean typeTextInToInputLastName (String LastName) {
		return webElementsOnPage.typeTextInToInput("Registration.LastName.Input", LastName);
	}
	public boolean typeTextInToInputPhone (String Phone) {
		return webElementsOnPage.typeTextInToInput("Registration.Phone.Input", Phone);
	}
	public boolean typeTextInToInputCity (String City) {
		return webElementsOnPage.typeTextInToInput("Registration.City.Input", City);
	}
	public boolean clickOnElementCity() {
		return webElementsOnPage.clickElement("Registration.City.Value");
	}
	public boolean typeTextInToInputStreet (String Street) {
		return webElementsOnPage.typeTextInToInput("Registration.Street.Input", Street);
	}
	public boolean typeTextInToInputNumBuilding (String NumBuilding) {
		return webElementsOnPage.typeTextInToInput("Registration.NumBuilding.Input", NumBuilding);
	}
	public boolean typeTextInToInputPassword (String Password) {
		return webElementsOnPage.typeTextInToInput("Registration.Password.Input", Password);
	}
	public boolean typeTextInToInputPasswordRepeat (String PasswordRepeat) {
		return webElementsOnPage.typeTextInToInput("Registration.PasswordRepeat.Input", PasswordRepeat);
	}
	public boolean setCheckBoxStateUncheck(String Uncheck) {
		return webElementsOnPage.setCheckBoxState("Registration.Checkbox.Uncheck", Uncheck);
	}
	public boolean clickOnElement() {
		return webElementsOnPage.clickElement("Registration.Checkbox.Lable");
	}
	public boolean ClickOnButtonRegister() {
		return webElementsOnPage.clickButton("Registration.Register.Button");	
	}
	public boolean checkValidationMessage() {
		  return webElementsOnPage.isElementPresentOnPage("Registration.Valid.Message"); 
	 }
	public boolean typeTextInToInputEmail() {
		webElementsOnPage.openNewTab();
		try {
			webElementsOnPage.openUrl(getCfgValue("Page_temp_email_URL"));
			String tempEmail = webElementsOnPage.getValue("Temp.Email.input");
			webElementsOnPage.closeNewTab();
			webElementsOnPage.typeTextInToInput("Registration.Email.Input", tempEmail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}		
}
