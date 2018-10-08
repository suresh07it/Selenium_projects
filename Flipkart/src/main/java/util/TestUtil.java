package util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestUtil {
	public static void dropDownSelection(WebDriver wd, String elementName, String elementValue) {
		WebElement oDropDown1 = wd.findElement(By.name(elementName));
		new Select(oDropDown1).selectByVisibleText(elementValue);
	}

	public static void textBoxSelectionName(WebDriver wd, String elementName, String elementValue) {
		WebElement textBox = wd.findElement(By.name(elementName));
		textBox.sendKeys(elementValue);
	}
	
	public static void textBoxSelectionClass(WebDriver wd, String className, String elementValue) {
		WebElement textBox = wd.findElement(By.className(className));
		textBox.sendKeys(elementValue);
	}
	
	public static void textBoxSelectionXpath(WebDriver wd, String xpath, String elementValue) {
		WebElement textBox = wd.findElement(By.xpath(xpath));
		textBox.sendKeys(elementValue);
	}

	public static void buttonClickByName(WebDriver wd, String elementName) {
		wd.findElement(By.name(elementName)).click();
	}
	
	public static void buttonClickByClass(WebDriver wd, String className) {
		wd.findElement(By.className(className)).click();
	}

	public static void buttonClickByXpath(WebDriver wd, String xpath) {
		wd.findElement(By.xpath(xpath)).click();
		// "//a[text()='Flights']"
	}
	public static void selectRadioButton(WebDriver wd, String name) {
		
	}
	public static String getTextByXpath(WebDriver wd, String xpath) {
		return wd.findElement(By.xpath(xpath)).getText();
	}
	
	public static List<WebElement> getListofElementsFromClass(WebDriver wd, String className) {
		return wd.findElements(By.className(className));
	}
	
	public static WebElement getListofElementFromClass(WebDriver wd, String className) {
		return wd.findElement(By.className(className));
	}
}
