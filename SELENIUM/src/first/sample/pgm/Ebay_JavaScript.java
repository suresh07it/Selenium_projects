package first.sample.pgm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class Ebay_JavaScript {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","G:\\SeliniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.ebay.in/");
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		System.out.println("Page Title : " + driver.getTitle());
		System.out.println("Current URL : " + driver.getCurrentUrl());
		ebaySearch(driver,"iPhone 7", "Mobile Phones");
		getSearchResult(driver);
	}
	
	
	public static void ebaySearch(WebDriver wd,String sSearch,String sCat) {
		WebElement oTxt,oDropDown,oBtn;
		oTxt = wd.findElement(By.xpath("//input[@id='gh-ac']"));
		oTxt.sendKeys(sSearch);
		
		oDropDown = wd.findElement(By.xpath("//select[@id='gh-cat']"));
		Select oSelect = new Select(oDropDown);
		System.out.println("DropDown is Multiple : "+oSelect.isMultiple());
		oSelect.selectByVisibleText(sCat);
		
		oBtn = wd.findElement(By.xpath("//input[@id='gh-btn']"));
		oBtn.click();
		
	}
	
		
	
	
	public static void getSearchResult(WebDriver wd) {
	
		WebElement oResultText,oElement;
		oResultText = wd.findElement(By.xpath("//span[@class='listingscnt']"));
		String sResult = oResultText.getText();
		sResult = sResult.replaceAll("[^0-9]", "");
		System.out.println("Search Result is : "+sResult);
		int iResult = Integer.parseInt(sResult);
		if(iResult>0) {
			System.out.println("Results are Available");
			List<WebElement> oList = wd.findElements(By.xpath("//ul[@id='ListViewInner']/li"));
			for(int i=0;i<oList.size();i++) {
				oElement = oList.get(i);
				//System.out.println(oElement.findElement(By.className("vip")).getText());
				System.out.println(oElement.findElement(By.xpath(".//a[@class='vip']")).getText());
				int x = oElement.getLocation().x;
				int y = oElement.getLocation().y;
				ScrollPageto(wd,x, y);
			}
			ScrollPageto(wd,0, 0);
			
		}else {
			System.out.println("Results are not Available");
		}
	}
	
	public static void ScrollPageto(WebDriver wd,int x,int y){
		JavascriptExecutor oJs;
		String sCmd;
		oJs = (JavascriptExecutor)wd;
		sCmd = String.format("window.scrollTo(%d,%d)",x,y);
		oJs.executeScript(sCmd);
			
	}
	
	public static void closeBrowser() {
		System.setProperty("webdriver.chrome.driver","G:\\SeliniumDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.close();
		driver.quit();
	}

}

