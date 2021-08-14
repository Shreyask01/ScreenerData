package pom;

import java.io.IOException;

import org.openqa.selenium.Keys;

import testbase.TestBase;

public class LargeCap extends TestBase {
	
	
	String marketcap;
	String roce;
	String roe;
	String pe;

	public void searchLargeCap() throws IOException {

		setText("searchComp_XPATH", helper.get("Stock"));
		pressKey("searchComp_XPATH", Keys.ENTER);
	}

	public String maketCap() {
		
	    marketcap =getTextFromElement("marketCap_XPATH");
		return marketcap;
	}

	public String roce() {
		 roce =getTextFromElement("ROCE_XPATH");
		return roce;
	}

	public String roe() {
		 roe =getTextFromElement("ROE_XPATH");
		return roe;
	}

	public String pe() {
	  pe =	getTextFromElement("PE_XPATH");
	return pe;
	}
	
	

}
