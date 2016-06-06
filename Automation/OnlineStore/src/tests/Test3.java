package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;
import static libs.DataExcelForTest.dataForTestAndToString;
import pages.Korzyna;

public class Test3 {
	//WebDriver driver = new OperaDriver();
	//WebDriver driver = new InternetExplorerDriver();
	//WebDriver driver = new FirefoxDriver();
	WebDriver driver = new ChromeDriver();
	Korzyna korzyna = new Korzyna(driver); 

	@Test
	public void test3(){
		Assert.assertTrue("The step not passed", korzyna.openMainUrl());
		Assert.assertTrue("The step not passed", korzyna.clickOnButtonKabinet());
		Assert.assertTrue("The step not passed", korzyna.typeTextInToInputLogin(dataForTestAndToString("Login", 2)));
		Assert.assertTrue("The step not passed", korzyna.typeTextInToInputPassword(dataForTestAndToString("Password", 2)));
		Assert.assertTrue("The step not passed", korzyna.clickOnButtonVoiti());
		Assert.assertTrue("The step not passed", korzyna.moveToElement());
		Assert.assertTrue("The step not passed", korzyna.clickLinkRumyana());
		Assert.assertTrue("The step not passed", korzyna.moveToElementRummyana());
		Assert.assertTrue("The step not passed", korzyna.clickElementKupit());
		Assert.assertTrue("The step not passed", korzyna.clickElementProdolzhit());
		Assert.assertTrue("The step not passed", korzyna.clickElementKorzina());
		Assert.assertTrue("The step not passed", korzyna.getValue());
		Assert.assertTrue("The step not passed", korzyna.clickElementOchistit());
	}
	@After
	public void tearDown() {
		korzyna.closeKabinetPageAndBrowser();
	}

}
