package testCases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.CreareScreener;
import pom.LargeCap;
import pom.LoginRepo;
import testbase.TestBase;
import utilities.ExcelReader;
import utilities.Utilities;

public class CreateScreenerTest extends TestBase {

	LoginRepo loginrepo;
	CreareScreener createscreen;
	int rownum;
	Utilities utl;

	@BeforeMethod
	public void loginToScreen() throws IOException, InterruptedException {

		loginrepo = new LoginRepo();
		invokeBrowser();
		loginrepo.login();

	}

	@Test(priority = 1)
	public void createScan() throws IOException {

		// Create new output excel
		ExcelReader outputExcel = new ExcelReader(System.getProperty("user.dir") + "\\Outputs\\" + timeStamp
				+ "\\FundamentaBulls_" + timeStamp + ".xlsx");

		createscreen = new CreareScreener();
		createscreen.createNewScreen();
		
		

		Hashtable<Integer, String> funbull = new Hashtable();
		funbull = getFundamentalBulls();

		for (int i = 1; i <= 10; i++) {

			outputExcel.setCellData("CreateScreenerTest", "Ratios", i + 1, funbull.get(i));


		}
	}

}
