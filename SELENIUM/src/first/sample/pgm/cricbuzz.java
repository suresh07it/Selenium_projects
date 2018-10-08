
package first.sample.pgm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cricbuzz {
	public static void buttonClickByName(WebDriver wd, String elementName) {
		wd.findElement(By.name(elementName)).click();
	}

	public static void buttonClickByXpath(WebDriver wd, String xpath) {
		wd.findElement(By.xpath(xpath)).click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "G:\\SeliniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.cricbuzz.com/");
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("Page Title : " + driver.getTitle());
		System.out.println("Current URL : " + driver.getCurrentUrl());
		buttonClickByXpath(driver, "//a[text()='Rankings']");
		WebElement oTable;
		oTable = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]"));
		List<WebElement> oRw = oTable.findElements(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[2]/div[1]"));
		for(int k=1;k<oRw.size();k++)
		{
			System.out.println(oRw.get(k).getText());
			//int i=k;
//			for(int j=0;j<4;j++)
//			{
//				String getText1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div["+k+"]/div["+j+"]")).getText(); 
//				System.out.print(getText1+"\t");
//				
//			}
//			System.out.print("\n");
			
		}
		
		
		
//			//			for (int i = 0; i < oList.size(); i++) {
//			oRow = oList.get(i);
//               System.out.println(oRow.getText());
//			
//	}
//			the=driver.findElement(By.id("teams-tab"));
//			the.click();
//		
//		he=driver.findElement(By.xpath("//a[@id='teams-tests-tab']"));
//		he.click();
//		oCell= driver.findElement(By.id("teams-tests"));
//		re=oCell.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-font-14 cb-brdr-thin-btm text-center']"));
//		for (int j = 0; j <re.size(); j++) {
//			t=re.get(j);
//			System.out.println(t.getText());
//			if(t.toString()=="INDIA");
//			{
//				
//			}
//			
//			}
		
		
}
}