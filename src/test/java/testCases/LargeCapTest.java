package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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
	String classname;
	
	
	


	@BeforeMethod
	public void loginToScreen() throws IOException, InterruptedException {

		classname= this.getClass().getName();
	
		System.out.println(classname);
		loadPropertyFiles();
		
		
		loginrepo = new LoginRepo();
		invokeBrowser();
		loginrepo.login();

	}

	@Test (priority = 1, dataProviderClass = Utilities.class,dataProvider = "dp")
	public void largeCapTest(Hashtable<String, String> data) throws IOException, InterruptedException {
		
		
		String stock = data.get("Stock");
		
		
		rownum = Integer.parseInt(data.get("rowNum"));
		
		 
		helper.put("Stock", stock);
		  
		largecap = new LargeCap(); 
		largecap.searchLargeCap();
		
		
		//Create new output excel
		ExcelReader outputExcel = new ExcelReader(
				System.getProperty("user.dir") + "\\Outputs\\" + timeStamp + "\\LargeCapTest\\" + timeStamp + ".xlsx");
		
		
		Thread.sleep(3000);
		
		String marketcap = largecap.maketCap();
	    String PE = largecap.pe();
		String ROCE = largecap.roce();
		String ROE = largecap.roe();
		String profit5 = largecap.profit5();
		String sales5 = largecap.sales5();
		String debteq = largecap.debteq();
		//String comment = largecap.comment();
			
		Thread.sleep(3000);
		
		outputExcel.setCellData("LargeCapTest", "market cap", rownum, marketcap);
		outputExcel.setCellData("LargeCapTest", "PE", rownum, PE);
		outputExcel.setCellData("LargeCapTest", "ROCE", rownum, ROCE); 
		outputExcel.setCellData("LargeCapTest", "ROE", rownum, ROE);
		outputExcel.setCellData("LargeCapTest", "Debt to eq", rownum, debteq);
		outputExcel.setCellData("LargeCapTest", "profit 5", rownum, profit5);
		outputExcel.setCellData("LargeCapTest", "sales 5", rownum, sales5);
		//outputExcel.setCellData("LargeCapTest", "comment", rownum, comment);
		
		Thread.sleep(3000);
		driver.quit();
	}

}
