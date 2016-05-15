package tests;

import static libs.DataForTest.dataForTestAndToString;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import pages.VartistDostavku;

public class TC4 {
	WebDriver driver = new ChromeDriver();
	VartistDostavku vartistDostavku = new VartistDostavku(driver);

	@Before
	public void OpenBroser() {
		Assert.assertTrue("Step is fail", vartistDostavku.OpenVartistDostavku());
	}
	
	@Test
	public void test() {
		Assert.assertTrue("Step is fail", vartistDostavku.typeTextToInputMistoVidpravnyk(dataForTestAndToString("MistoVidpravnyk", 4)));
		Assert.assertTrue("Step is fail", vartistDostavku.typeTextToInputMistoOderguvach(dataForTestAndToString("MistoOderguvach", 4)));
		Assert.assertTrue("Step is fail", vartistDostavku.clickOnElementTypePoslug());
		Assert.assertTrue("Step is fail", vartistDostavku.clickOnElementTypePoslugValue());
		Assert.assertTrue("Step is fail", vartistDostavku.clickOnElementVydVydprauvlenya());
		Assert.assertTrue("Step is fail", vartistDostavku.clickOnElementVydVydprauvlenyaValue());
		Assert.assertTrue("Step is fail", vartistDostavku.typeTextToInputOgoloshenaVartist(dataForTestAndToString("OgoloshenaVartist", 4)));
		Assert.assertTrue("Step is fail", vartistDostavku.putCheckbox(true));
		Assert.assertTrue("Step is fail", vartistDostavku.clickOnElementPoslugaZvorotnyaDostavka());
		Assert.assertTrue("Step is fail", vartistDostavku.clickOnElementPoslugaZvorotnyaDostavkaValue());
		Assert.assertTrue("Step is fail", vartistDostavku.clickOnBattonRozrahuvatyVartyst());
		Assert.assertTrue("Step is fail", vartistDostavku.clickOnLinkOchystyt());
		Assert.assertFalse("Expected result not found", vartistDostavku.checkValidationMessage());
	
	}
	
	@After
	public void closeBrowser() {
		vartistDostavku.closePageAndBrowser();
	}
}
