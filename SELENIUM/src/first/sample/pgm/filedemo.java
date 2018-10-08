package first.sample.pgm;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.htmlunit.HtmlUnitDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;


	public class filedemo {
		
		public static WebDriver driver;
		public static int iBroType = 1; //1 - Chrome,2 - FF, 3 - IF,4 - Edge, 5 - HTML Unit Driver
		public static String sURL = "https:\\\\www.google.co.in";

		public static void main(String[] args) {
			invokeBrowser();
			browserSettings();
			navigateURL();
			getPageInfo();
			googleSearch("Selenium HQ");
			closeBrowser();

		}
		
		public static void invokeBrowser() {
			
			switch (iBroType) {
			case 1:
				System.out.println("User Option is : "+iBroType+", So Invoking the Chrome Browser");
				System.setProperty("webdriver.chrome.driver", "G:\\SeliniumDrivers\\chromedriver.exe");
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
		
		public static void googleSearch(String sSearch) {
			WebElement oTxt,oBtn,oLink;
			oTxt = driver.findElement(By.id("lst-ib"));
			oTxt.sendKeys(sSearch);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			oBtn = driver.findElement(By.className("lsb"));
			oBtn.click();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			oLink = driver.findElement(By.xpath("//a[text()='Selenium - Web Browser Automation']"));
			oLink.click();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			getPageInfo();
		}
		
		public static void closeBrowser() {
			//driver.close();
			driver.quit();
		}

	}









	
		