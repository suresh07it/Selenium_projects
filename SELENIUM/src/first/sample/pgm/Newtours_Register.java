package first.sample.pgm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Newtours_Register {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\SeliniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://newtours.demoaut.com");
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		System.out.println("Page Title : " + driver.getTitle());
		System.out.println("Current URL : " + driver.getCurrentUrl());
		textBoxSelection(driver, "userName", "invalidUNN");
		textBoxSelection(driver, "password", "invalidPWD");
		buttonClickByName(driver, "login");
		

		WebElement oBtn, radio,radio1,radio3,radio2,check;
		oBtn = driver.findElement(By.xpath("//a[text()='Flights']"));
		oBtn.click();

		radio = driver.findElement(By.xpath("//input[@name='tripType' and @value='oneway']"));
		radio.click();
		dropDownSelection(driver, "passCount", "2");
		dropDownSelection(driver, "fromMonth", "August");
		dropDownSelection(driver, "fromPort", "New York");
		dropDownSelection(driver, "toPort", "Paris");
		dropDownSelection(driver, "toMonth", "August");
		dropDownSelection(driver, "toDay" , "31");
		radio1=driver.findElement(By.xpath("//input[@name='servClass' and @value='Business']"));
		radio1.click();
		dropDownSelection(driver, "airline" , "Unified Airlines");
		buttonClickByName(driver,"findFlights");
		
		
		radio3=driver.findElement(By.xpath("//input[@name='outFlight' and @value='Blue Skies Airlines$361$271$7:10']"));
		radio3.click();
		radio2=driver.findElement(By.xpath("//input[@name='inFlight' and @value='Pangea Airlines$632$282$16:37']"));
		radio2.click();
		
		buttonClickByName(driver,"reserveFlights");
		
		textBoxSelection(driver,"passFirst0","Suresh");
		textBoxSelection(driver,"passLast0","M");
		textBoxSelection(driver,"billAddress1","B1 Aparajita Apartment");
		textBoxSelection(driver,"billAddress2","AGS Colony");
		textBoxSelection(driver,"billCity","Chennai");
		textBoxSelection(driver,"billState", "Tamilnadu");
		textBoxSelection(driver,"billZip", "600042");
		dropDownSelection(driver,"billCountry", "INDIA");
		buttonClickByName(driver,"buyFlights");
		check=driver.findElement(By.xpath("//input[@name='ticketLess' and @'value='checkbox']"));
		check.click();
		
		

	}

	private static void dropDownSelection(WebDriver wd, String elementName, String elementValue) {
		WebElement oDropDown1 = wd.findElement(By.name(elementName));
		new Select(oDropDown1).selectByVisibleText(elementValue);
	}

	private static void textBoxSelection(WebDriver wd, String elementName, String elementValue) {
		WebElement textBox = wd.findElement(By.name(elementName));
		textBox.clear();
		textBox.sendKeys(elementValue);
	}

	private static void buttonClickByName(WebDriver wd, String elementName) {
		wd.findElement(By.name(elementName)).click();
	}

	
}
