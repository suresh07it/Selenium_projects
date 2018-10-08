package first.sample.pgm;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Invoke_Edge {
	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver","G:\\seliniumdrivers\\MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		System.out.println("Page Title : "+driver.getTitle());
		System.out.println("Current URL : "+driver.getCurrentUrl());
		driver.close();

	}

}
