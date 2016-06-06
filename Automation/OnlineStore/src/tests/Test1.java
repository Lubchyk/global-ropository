package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static libs.DataExcelForTest.dataForTestAndToString;
import pages.KabinetPage;

public class Test1 {
	WebDriver driver = new ChromeDriver();
	KabinetPage kabinetPage = new KabinetPage(driver);

	@Test
	public void test1(){
		Assert.assertTrue("The step not passed", kabinetPage.openKabinetPage());
		Assert.assertTrue("The step not passed", kabinetPage.clickOnButtonKabinet());
		Assert.assertTrue("The step not passed", kabinetPage.clickOnLinkRegistration());
		Assert.assertTrue("The step not passed", kabinetPage.typeTextInToInputFirstName(dataForTestAndToString("FirstName", 1)));
		Assert.assertTrue("The step not passed", kabinetPage.typeTextInToInputLastName(dataForTestAndToString("LastName", 1)));
		Assert.assertTrue("The step not passed", kabinetPage.typeTextInToInputPhone(dataForTestAndToString("Phone", 1)));
		Assert.assertTrue("The step not passed", kabinetPage.typeTextInToInputEmail());
		Assert.assertTrue("The step not passed", kabinetPage.typeTextInToInputCity(dataForTestAndToString("City", 1)));
		Assert.assertTrue("The step not passed", kabinetPage.clickOnElementCity());
		Assert.assertTrue("The step not passed", kabinetPage.typeTextInToInputStreet(dataForTestAndToString("Street", 1)));
		Assert.assertTrue("The step not passed", kabinetPage.typeTextInToInputNumBuilding(dataForTestAndToString("NumBuilding", 1)));
		Assert.assertTrue("The step not passed", kabinetPage.typeTextInToInputPassword(dataForTestAndToString("Password", 1)));
		Assert.assertTrue("The step not passed", kabinetPage.typeTextInToInputPasswordRepeat(dataForTestAndToString("PasswordRepeat", 1)));
		Assert.assertTrue("The step not passed", kabinetPage.clickOnElement());
		Assert.assertTrue("The step not passed", kabinetPage.ClickOnButtonRegister());
		Assert.assertTrue("The step not passed", kabinetPage.checkValidationMessage());
	}
	@After
	public void tearDown() {
		kabinetPage.closeKabinetPageAndBrowser();
	}


}