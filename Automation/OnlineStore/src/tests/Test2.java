package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static libs.DataExcelForTest.dataForTestAndToString;
import pages.OwnKabinet;

public class Test2 {
	WebDriver driver = new ChromeDriver();
	OwnKabinet ownKabinet = new OwnKabinet(driver);

	@Test
	public void test2() {
		Assert.assertTrue("The step not passed", ownKabinet.openOwnKabinet());
		Assert.assertTrue("The step not passed", ownKabinet.clickOnButtonKabinet());
		Assert.assertTrue("The step not passed", ownKabinet.typeTextInToInputLogin(dataForTestAndToString("Login", 2)));
		Assert.assertTrue("The step not passed", ownKabinet.typeTextInToInputPassword(dataForTestAndToString("Password", 2)));
		Assert.assertTrue("The step not passed", ownKabinet.clickOnButtonVoiti());
		Assert.assertTrue("The step not passed", ownKabinet.clickButtonKabinetUser());
		Assert.assertTrue("The step not passed", ownKabinet.clickOnLinkVyiti());
		Assert.assertTrue("The step not passed", ownKabinet.clickKabinetButton());
		Assert.assertTrue("The step not passed", ownKabinet.checkButtonVoiti());
	}
	
	@After
	public void tearDown() {
		ownKabinet.closeKabinetPageAndBrowser();
	}




}
