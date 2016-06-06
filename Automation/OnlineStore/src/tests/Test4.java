package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;
import pages.Search;

public class Test4 {
	//WebDriver driver = new OperaDriver();
	WebDriver driver = new InternetExplorerDriver();
	//WebDriver driver = new FirefoxDriver();
	//WebDriver driver = new ChromeDriver();
	Search search = new Search(driver);
	
	@Test
	public void test4() {
		Assert.assertTrue("The step not passed", search.openMainPage());
		Assert.assertTrue("The step not passed", search.typeTextInToInputValue("мыло"));
		Assert.assertTrue("The step not passed", search.clickOnButtonSearch());
		Assert.assertTrue("The step not passed", search.isElementPresentOnPage());		
	}
	@After
	public void tearDown() {
		search.closeMainPageAndBrowser();
	}
}
