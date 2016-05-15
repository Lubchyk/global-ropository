package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static libs.DataForTest.dataForTestAndToString;
import pages.ReestraciyaPage;

public class TC3 {
	WebDriver driver = new ChromeDriver();
	ReestraciyaPage reestraciyaPage = new ReestraciyaPage(driver);

	@Before
	public void openBrowser() {
		reestraciyaPage.openReestraciyaPage();
	}
	@Test
	public void test() {	
	Assert.assertTrue("Step is fail", reestraciyaPage.clickOnElementMisto());
	Assert.assertTrue("Step is fail", reestraciyaPage.clickOnElementMistoValue());
	Assert.assertTrue("Step is fail", reestraciyaPage.typeTextToInputPrisvushche(dataForTestAndToString("Prisvushche", 3)));
	Assert.assertTrue("Step is fail", reestraciyaPage.typeTextToInputImya(dataForTestAndToString("Imya", 3)));
	Assert.assertTrue("Step is fail", reestraciyaPage.typeTextToInputPoBatkovi(dataForTestAndToString("PoBatkovi", 3)));
	Assert.assertTrue("Step is fail", reestraciyaPage.typeTextToInputPhone(dataForTestAndToString("Phone", 3)));
	Assert.assertTrue("Step is fail", reestraciyaPage.typeTextToInputEmail(dataForTestAndToString("Email", 3)));
	Assert.assertTrue("Step is fail", reestraciyaPage.clickOnElementStat());
	Assert.assertTrue("Step is fail", reestraciyaPage.clickOnElementStatValue());
	Assert.assertTrue("Step is fail", reestraciyaPage.clickOnBaton());
	Assert.assertTrue("Step is fail", reestraciyaPage.checkValidationMessage());
	
	
	}
	@After
	public void closeBrowser() {
		reestraciyaPage.closePageAndBrowser();
	}
	
}
