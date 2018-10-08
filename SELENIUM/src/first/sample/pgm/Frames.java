package first.sample.pgm;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class Frames {
	public static void Switch_To_Alert() throws Exception{
		System.setProperty("webdriver.chrome.driver", "G:\\SeliniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.cssSelector("button")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		System.out.println("Execution Completed");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Switch_To_Alert();
		System.setProperty("webdriver.chrome.driver", "G:\\SeliniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("Page Title : " + driver.getTitle());
		System.out.println("Current URL : " + driver.getCurrentUrl());
			WebElement oFrame;
			oFrame = driver.findElement(By.name("packageListFrame"));
			driver.switchTo().frame(oFrame);
			driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("packageFrame");
			driver.findElement(By.linkText("CommandProcessor")).click();
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("classFrame");
			driver.findElement(By.linkText("HttpCommandProcessor")).click();
			
		

	}
}
