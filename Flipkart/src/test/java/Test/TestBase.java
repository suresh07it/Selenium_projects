package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import page.Homepage;
import page.Loginpage;
import page.Searchpage;

public class TestBase {
	public WebDriver driver;
	public int iBroType; // 1 - Chrome,2 - FF, 3 - IF,4 - Edge, 5 - HTML Unit Driver
	public ExtentHtmlReporter reporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	public ExtentTest extentTest2;
	public ExtentTest extentTest3;
	public ExtentTest extentTest4;
	public FileInputStream file = null;
	public Properties prop;

	@BeforeSuite
	public void invokeBrowser() {
		prop = propertyReader();
		reporter = new ExtentHtmlReporter(prop.getProperty("reporterPath"));
		extentReports = new ExtentReports();
		extentReports.attachReporter(reporter);
		extentTest = extentReports.createTest("Browser selection");
		iBroType = Integer.parseInt(prop.getProperty("browType"));
		switch (iBroType) {
		case 1:
			System.out.println("User Option is : " + iBroType + ", So Invoking the Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "G:\\SeliniumDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			extentTest.log(Status.INFO, "User Option is : " + iBroType + ", So Invoking the Chrome Browser");
			break;
		case 2:
			System.out.println("User Option is : " + iBroType + ", So Invoking the FF Browser");
			System.setProperty("webdriver.gecko.driver", "G:\\SeliniumDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			extentTest.log(Status.INFO, "User Option is : " + iBroType + ", So Invoking the FF Browser");
			break;
		case 3:
			System.out.println("User Option is : " + iBroType + ", So Invoking the IE Browser");
			System.setProperty("webdriver.ie.driver", "G:\\SeliniumDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			extentTest.log(Status.INFO, "User Option is : " + iBroType + ", So Invoking the IE Browser");
			break;
		case 4:
			System.out.println("User Option is : " + iBroType + ", So Invoking the Edge Browser");
			System.setProperty("webdriver.edge.driver", "G:\\SeliniumDrivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			extentTest.log(Status.INFO, "User Option is : " + iBroType + ", So Invoking the Edge Browser");
		case 5:
			System.out.println("User Option is : " + iBroType + ", So Invoking the Headless Browser");
			driver = new HtmlUnitDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			extentTest.log(Status.INFO, "User Option is : " + iBroType + ", So Invoking the Headless Browser");
			break;
		default:
			System.out.println("User Selection is wrong :" + iBroType + " ,So Invoking Default Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "G:\\SeliniumDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			extentTest.log(Status.INFO, "User Selection is wrong :" + iBroType + " ,So Invoking Default Chrome Browser");
			break;
		}

	}

	public Properties propertyReader() {
		String sFile = "C:\\Users\\Suresh M\\eclipse_workspace_oxygen\\Flipkart\\src\\main\\java\\Config\\config.properties";
		File ofile = new File(sFile);
		try {
			file = new FileInputStream(ofile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	@Test
	public void flipKartLaunch() {
		Homepage hp = new Homepage(driver, prop);
		boolean lauchUrl = hp.lauchUrl();
		extentTest2 = extentReports.createTest("Flipkart Lauch");
		if (lauchUrl)
			extentTest2.log(Status.PASS, "URL successfully lauched");
		else
			extentTest2.log(Status.PASS, "URL failed to lauched");
		extentReports.flush();
	}

	@Test(dependsOnMethods = "flipKartLaunch")
	public void flipKartLogin() {
		Loginpage lp = new Loginpage(driver, prop);
		lp.loginToFlipkart();
		extentTest3 = extentReports.createTest("Flipkart Login");
		extentTest3.log(Status.PASS, "Login successfully");
		extentReports.flush();
	}

	@Test(dependsOnMethods = "flipKartLogin")
	public void flipKartSearchAndAddCard() {
		Searchpage sp = new Searchpage(driver, prop, prop.getProperty("excelfile"), prop.getProperty("sheetname"));
		sp.searchAndAddCart();
		extentTest4 = extentReports.createTest("Flipkart Search and Cart");
		extentTest4.log(Status.PASS, "Add to cart successfully");
		extentReports.flush();
	}
}
