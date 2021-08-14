package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pom.LoginRepo;
import testbase.TestBase;

public class LoginScreener extends TestBase {

	LoginRepo loginrepo;
	String result;

	@Test
	public void loginToScreener() throws IOException, InterruptedException {

		loginrepo = new LoginRepo();
		invokeBrowser();
		Thread.sleep(5000);
		result =loginrepo.login();

	}

}
