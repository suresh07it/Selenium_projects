package first.sample.pgm;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 import org.openqa.selenium.support.ui.Select;
 import java.util.List;

public class Newtours {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","G:\\SeliniumDrivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("http://newtours.demoaut.com");
	driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
	System.out.println("Page Title : "+driver.getTitle());
	System.out.println("Current URL : "+driver.getCurrentUrl());
	WebElement oTxt,oDropDown,oBtn;
	oBtn = driver.findElement(By.xpath("//a[text()='REGISTER']"));
	System.out.println(" Button is displayed : "+oBtn.isDisplayed());
	oBtn.click();
	oDropDown = driver.findElement(By.xpath("//select[@name=\"country\"]"));
	Select oselect=new Select(oDropDown);
	oselect.selectByVisibleText("INDIA");
	System.out.println("DropDown is Multiple : "+oselect.isMultiple());
	List <WebElement> list_options= oselect.getOptions();
	System.out.println(list_options.size());
	for(int i=0;i<list_options.size();i++)
	{
		String dat=list_options.get(i).getText();
		System.out.println(dat);
	}
	
	
	
	

}
}