package tests;

import static libs.DataExcelForTest.dataForTestAndToString;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ForgotYourPassword;

public class Test5 {
	WebDriver driver = new ChromeDriver();
	ForgotYourPassword forgotYourPassword = new ForgotYourPassword(driver);
	
	@Test
	public void test5(){
		Assert.assertTrue("The step not passed", forgotYourPassword.openMainPage());
		Assert.assertTrue("The step not passed", forgotYourPassword.clickOnButtonKabinet());
		Assert.assertTrue("The step not passed", forgotYourPassword.typeTextInToInputLogin(dataForTestAndToString("Login", 5)));
		Assert.assertTrue("The step not passed", forgotYourPassword.typeTextInToInputPassword(dataForTestAndToString("Password", 5)));
		Assert.assertTrue("The step not passed", forgotYourPassword.clickOnButtonVoiti());
		Assert.assertTrue("The step not passed", forgotYourPassword.typeTextInToInputRecoverLogin(dataForTestAndToString("RecoverLogin", 5)));
		Assert.assertTrue("The step not passed", forgotYourPassword.clickOnButtonNapomnit());
		Assert.assertTrue("The step not passed", forgotYourPassword.isElementPresentOnPage());	
	}	
	@After
	public void tearDown() {
		forgotYourPassword.closeMainPageAndBrowser();
	}

}
