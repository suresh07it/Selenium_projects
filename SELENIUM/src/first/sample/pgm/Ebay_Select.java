package first.sample.pgm;





import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class Ebay_Select {

	public static WebDriver driver;
	public static int iBroType = 1; //1 - Chrome,2 - FF, 3 - IF,4 - Edge, 5 - HTML Unit Driver
	public static String sURL = "https://www.flipkart.com/";

	public static void main(String[] args) throws InterruptedException {
		invokeBrowser();
		browserSettings();
		navigateURL();
		getPageInfo();
		driver.findElement(By.xpath("//button [@class='_2AkmmA _29YdH8']")).click();
		ebaySearch("iPhone 7");
		getSearchResult();
		//closeBrowser();

	}

	public static void invokeBrowser() {

		switch (iBroType) {
		case 1:
			System.out.println("User Option is : "+iBroType+", So Invoking the Chrome Browser");
			System.setProperty("webdriver.chrome.driver","G:\\SeliniumDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User Option is : "+iBroType+", So Invoking the FF Browser");
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case 3:
			System.out.println("User Option is : "+iBroType+", So Invoking the IE Browser");
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case 4:
			System.out.println("User Option is : "+iBroType+", So Invoking the Edge Browser");
			System.setProperty("webdriver.edge.driver", "./Driver/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		case 5:
			System.out.println("User Option is : "+iBroType+", So Invoking the Headless Browser");
			driver = new HtmlUnitDriver();
			break;
		default:
			System.out.println("User Selection is wrong :"+iBroType+" ,So Invoking Default Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}

	}

	public static void browserSettings() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public static void navigateURL() {
		//driver.get(sURL);
		driver.navigate().to(sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public static void getPageInfo() {
		System.out.println("Page Title is : "+driver.getTitle());
		System.out.println("Page Current URL is : "+driver.getCurrentUrl());
	}

	public static void ebaySearch(String sSearch) {
		WebElement oTxt,oDropDown,oBtn;
		oTxt = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		oTxt.sendKeys(sSearch);


		oBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		oBtn.click();

	}

	public static void getSearchResult() throws InterruptedException {
		WebElement oResultText,oElement;
		Thread.sleep(5000);
		oResultText = driver.findElement(By.className("_2yAnYN"));
		String sResult = oResultText.getText();
		String[] split = sResult.split(" ");
		int count = Integer.parseInt(split[5]);
		System.out.println(count);
		if(count>0) {
			
			WebElement masterList = driver.findElement(By.xpath("//div[@class='_1HmYoV _35HD7C col-10-12']"));
			
			System.out.println("Results are Available");
			List<WebElement> oList = masterList.findElements(By.xpath("//div[@class='bhgxx2 col-12-12']"));
			System.out.println(oList.size());
			/*for(int i=0;i<oList.size();i++) {
				if(i==0 || i==oList.size()-1) continue;
				oElement = oList.get(i);
				System.out.println(oElement.getText());
				//System.out.println(oElement.findElement(By.className("vip")).getText());
				List<WebElement> o =oElement.findElements(By.xpath("//div[@class=\"_3wU53n\"]"));
				for(int j=0;j<o.size();j++) {
					WebElement k =o.get(j);
					System.out.println(k.getText());


				}
			}*/

		}else {
			System.out.println("Results are not Available");
		}
	}

	public static void closeBrowser() {
		//driver.close();
		driver.quit();
	}

}














