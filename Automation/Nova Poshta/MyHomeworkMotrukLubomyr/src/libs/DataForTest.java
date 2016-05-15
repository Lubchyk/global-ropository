package libs;

import java.util.Map;
import org.junit.Assert;
import static libs.ExcelDriver.getMultipleData;

public class DataForTest {

	static Map tempVar1 = null;
	static Map tempVar2 = null;
	
public static String dataForTestAndToString(String key, int i) {
	tempVar2 = dataForTest("DATA_FILE", ("Test" + i), 1);
	return	tempVar2.get(key).toString();
}
public static Map dataForTest(String key, String sheetName, int columnNumber ) {
	try {
		tempVar1 = getMultipleData(ConfigData.getCfgValue(key), sheetName, columnNumber);
	} catch (Exception e) {
		Assert.fail("Can not work with Date TestData.xls " + e);
	}
	return tempVar1;	
	}
}
