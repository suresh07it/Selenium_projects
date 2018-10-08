package test.pack;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Link {

	public static  WebDriver driver;
	
		@BeforeTest(groups="Regression")
		public void invoke_browser() {
		System.setProperty("webdriver.chrome.driver","G:\\SeliniumDrivers\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		}
		@Test(priority=1)
		public void getTitle() {
			driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		System.out.println("Page Title : "+driver.getTitle());
		System.out.println("Current URL : "+driver.getCurrentUrl());
		
		}
		@DataProvider(name="data")
		public Object dataproviderMethod(){
			Object[][] parent=new Object[1][1];
		 parent[0][0]=driver.getWindowHandle();
		 return parent;
		
		}
		
		
		
		@Test(priority=2,dependsOnMethods="getTitle",groups= {"Smoke","sanity","Regression"})
		public void openwindow() {
			driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Open New Seperate Windows')]")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		}
		@Test(priority=3,dataProvider="data")
		public void handlewindows(String parent) {
			driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
	
		
		Set<String> child= driver.getWindowHandles();
		System.out.println(child.toString());
		System.out.println(child.size());
		for(String s:child) {
			driver.switchTo().window(
					s);	
		}
		
		System.out.println("Current URL : "+driver.getCurrentUrl());
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//a[contains(text(),'WebTable')]")).click();
		}

	

}
