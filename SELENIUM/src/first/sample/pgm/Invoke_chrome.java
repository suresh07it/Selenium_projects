package first.sample.pgm;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Invoke_chrome {

		public static void main(String[] args) {
		
			System.setProperty("webdriver.chrome.driver", "G:\\SeliniumDrivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.google.co.in/");
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			System.out.println("Page Title : "+driver.getTitle());
			System.out.println("Current URL : "+driver.getCurrentUrl());
			driver.close();

		}

	}

