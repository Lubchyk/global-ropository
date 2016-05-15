package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static libs.DataForTest.dataForTestAndToString;
import pages.TerminDostavky;

public class TC2 {
	
	WebDriver driver = new ChromeDriver();
	TerminDostavky terminDostavky = new TerminDostavky(driver);
@Before
public void OpenBroser() {
Assert.assertTrue("Step is fail",terminDostavky.openTerminDostavkyPage());
}
@Test
public void test() {
	Assert.assertTrue("Some step is fail",terminDostavky.vvodDatuVidpravky(dataForTestAndToString("DatuVidpravky", 2)) &
	terminDostavky.clickOnElementTypePoslug() &
	terminDostavky.typeTextToInputTypePoslug(dataForTestAndToString("TypePoslug", 2)) &
	terminDostavky.clickOnElementMistoVidpraunyk() &
	terminDostavky.typeTextToInputMistoVidpraunyk(dataForTestAndToString("MistoVidpraunyk", 2)) &
	terminDostavky.clickOnElementMistoOderguvach() &
	terminDostavky.typeTextToInputMistoOderguvach(dataForTestAndToString("MistoOderguvach", 2)) &
	terminDostavky.clickOnBattonRozrahuvatyVartist() &
	terminDostavky.checkValidationMessage());
}
@After
public void closeUrlAndBrowser() {
	terminDostavky.closeUrlAndBrovser();
}

}

