package pom;

import java.io.IOException;

import org.openqa.selenium.By;

import testbase.TestBase;

public class LoginRepo extends TestBase {

	public String login() throws IOException, InterruptedException {

		System.out.println("login repo is running ---------");
		
		//driver.findElement(By.xpath("//i[@class='icon-user-line blue-icon']")).click();
		
		
		//driver.findElement(By.xpath(OR.getProperty("loginBtn_xpath"))).click();
		
		object_Click("loginBtn_XPATH");
		setText("username_XPATH", pro.getProperty("username"));
		setText("password_XPATH", pro.getProperty("password"));
		object_Click("LoginScreen_XPATH");
		return null;
		
		
		////*[contains(text(),'S.No.')]/parent::th/parent::tr/preceding-sibling::tr[1]/td[1]
		
		
		
		//*[contains(text(),'S.No.')]/parent::th/parent::tr/following-sibling::tr[1]/td[2]
		
		

	}

}
