package page;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import util.TestUtil;

public class Homepage {

	WebDriver wd;
	Properties prop;

	public Homepage(WebDriver wd, Properties prop) {
		this.wd = wd;
		this.prop = prop;
	}

	public boolean lauchUrl() {
		wd.get(prop.getProperty("url"));
		String text = TestUtil.getTextByXpath(wd, "//span[@class='_1hgiYz']//span[contains(text(),'Login')]");
		System.out.println(text);
		if (text.equals("Login"))
			return true;
		else
			return false;
	}
}
