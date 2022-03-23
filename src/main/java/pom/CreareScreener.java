package pom;

import java.io.IOException;

import testbase.TestBase;

public class CreareScreener extends TestBase {
	
	String getquery;
	
	
	public void createNewScreen() throws IOException {
		
		object_Click("screens_XPATH");
		
//		object_Click("screens_XPATH ");
		object_Click("newscreen_XPATH");
		
		getquery = getInputText();
		
		setText("newquery_XPATH", getquery);
		
		
		object_Click("runquery_XPATH");
		
		///parent::th
		////a[contains(text(),'S.No.')]/parent::th/parent::tr/following-sibling::tr[1]/td[2]/a[1]
	}
	
	

}
