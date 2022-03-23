package pom;

import java.io.IOException;

import org.openqa.selenium.Keys;

import testbase.TestBase;

public class LargeCap extends TestBase {
	
	
	String marketcap;
	String roce;
	String roe;
	String pe;
	String profit5;
	String sales5;
	String debtequ;
	String comment;

	public void searchLargeCap() throws IOException {

		setText("searchComp_XPATH", helper.get("Stock"));
		pressKey("searchComp_XPATH", Keys.ENTER);
	}

	public String maketCap() {
		
	    marketcap =getTextFromElement("marketCap_XPATH");
	    System.out.println(marketcap);
		return marketcap;
	}

	public String roce() {
		 roce =getTextFromElement("ROCE_XPATH");
		 System.out.println(roce);
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
	
	public String profit5() {
		profit5 = getTextFromElement("profit5_XPATH");
		return profit5;
	}
	
	public String sales5() {
		sales5 = getTextFromElement("sales5_XPATH");
		return sales5;
	}
	
	
	public String debteq() {
		
		debtequ = getTextFromElement("debteq_XPATH");
		return debtequ;
		
	}
	
	
	
	public String comment() {
		
		if(Integer.parseInt(roce) >15 && Integer.parseInt(roe)>15) {
			
			comment = comment + "Good Returns";
		}
		
		if(Integer.parseInt(profit5)>20 && Integer.parseInt(sales5)>20) {
			comment = comment + "Profitable";
		}
		
		if (Integer.parseInt(pe)< 30) {
			comment = comment + "Good valuation";
		}
		
		
		return comment;
		}
	
	
	
	
	
	
	

}
