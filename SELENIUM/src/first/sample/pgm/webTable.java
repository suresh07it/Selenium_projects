package first.sample.pgm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class webTable {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","G:\\SeliniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.seleniumhq.org/download/");
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		System.out.println("Page Title : " + driver.getTitle());
		System.out.println("Current URL : " + driver.getCurrentUrl());
		WebElement oTable,oRow,oCell,ot,or,oc;
		oTable = driver.findElement(By.xpath("(//div[@id='mainContent']/table)[1]/tbody"));
		List<WebElement> oList = oTable.findElements(By.tagName("tr"));
//		for(int i=0;i<oList.size();i++){
//			oRow =oList.get(i);
//					
//
//.tagName("td"));
//			for(int j=0;j<oColList.size();j++){
//			oCell = oColList.get(j);
//				System.out.print(oCell.getText()+"  ");
//			}
//			System.out.println();
//		}
//	
	ot=driver.findElement(By.xpath("(//div[@id='mainContent']/table)[2]/tbody"));
	List<WebElement> oList1 = ot.findElements(By.tagName("tr"));
	for(int i=0;i<oList1.size();i++){
		or =oList1.get(i);
			
		List<WebElement> oColList1 = or.findElements(By.tagName("td"));
		for(int j=0;j<oColList1.size();j++){
		oc = oColList1.get(j);
			System.out.print(oc.getText()+"  ");
		}
		System.out.println();
	}
}

}
