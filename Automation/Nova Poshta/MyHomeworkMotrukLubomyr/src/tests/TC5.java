package tests;

import static libs.DataForTest.dataForTestAndToString;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.KabinetPage;

public class TC5 {

	WebDriver driver = new ChromeDriver();
	KabinetPage kabinetPage = new KabinetPage(driver);
	
	@Before
	public void OpenBrowser() {
		kabinetPage.openKabinetPage();
		
	}
	@Test
	public void test() {
		Assert.assertTrue("Some step is fail",kabinetPage.clickOnLinkVhod() &
		kabinetPage.typeTextToInputLogin(dataForTestAndToString("Login", 5)) &
		kabinetPage.typeTextToInputPassword(dataForTestAndToString("Password", 5)) &
		kabinetPage.clickOnButtonUvity() &
		kabinetPage.clickOnLinkNalashtuvanna() &
		kabinetPage.clickOnCheckboxPhone(false) &
		kabinetPage.clickOnCheckboxOgoloshenaVartist(false) &
		kabinetPage.clickOnCheckboxDataPostavku(false) &
		kabinetPage.clickOnButtonPidtverdutu() &
		kabinetPage.findElement());
	}
	@After
	public void tearDown() {
		kabinetPage.clickOnLinkNalashtuvanna();
		kabinetPage.clickOnCheckboxPhone(!false);
		kabinetPage.clickOnCheckboxOgoloshenaVartist(true);
		kabinetPage.clickOnCheckboxDataPostavku(!false);
		kabinetPage.clickOnButtonPidtverdutu();
		kabinetPage.closeBrowser();
	}
}
