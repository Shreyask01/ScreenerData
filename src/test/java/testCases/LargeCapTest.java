package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.ExcelReader;
import pom.LargeCap;
import pom.LoginRepo;
import testbase.TestBase;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import utilities.Utilities;

public class LargeCapTest extends TestBase {

	LoginRepo loginrepo;
	LargeCap largecap;
	int rownum;

	@BeforeMethod
	public void loginToScreen() throws IOException, InterruptedException {

		loginrepo = new LoginRepo();
		invokeBrowser();
		loginrepo.login();

	}

	@Test (priority = 1, dataProviderClass = Utilities.class,dataProvider = "dp")
	public void largeCapTest(Hashtable<String, String> data) throws IOException {
		
		String stock = data.get("Stock");
		
		
		rownum = Integer.parseInt(data.get("rowNum"));
		
		 
		helper.put("Stock", stock);
		  
		largecap = new LargeCap(); 
		largecap.searchLargeCap();
		
		
		//Create new output excel
		ExcelReader outputExcel = new ExcelReader(
				System.getProperty("user.dir") + "\\Outputs\\" + timeStamp + "\\Largecap_" + timeStamp + ".xlsx");
		
		
		String marketcap = largecap.maketCap();
	    String PE = largecap.pe();
		String ROCE = largecap.roce();
		String ROE = largecap.roe();
		
		outputExcel.setCellData("LargeCapTest", "market cap", rownum, marketcap);
		outputExcel.setCellData("LargeCapTest", "PE", rownum, PE);
		outputExcel.setCellData("LargeCapTest", "ROCE", rownum, ROCE); 
		outputExcel.setCellData("LargeCapTest", "ROE", rownum, ROE);
		
		
		
		
	}

}
