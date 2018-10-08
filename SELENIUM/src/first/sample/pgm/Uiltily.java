package first.sample.pgm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Uiltily {
	private static void dropDownSelection(WebDriver wd, String elementName, String elementValue) {
		WebElement oDropDown1 = wd.findElement(By.name(elementName));
		new Select(oDropDown1).selectByVisibleText(elementValue);
	}

	private static void textBoxSelection(WebDriver wd, String elementName, String elementValue) {
		WebElement textBox = wd.findElement(By.name(elementName));
		textBox.sendKeys(elementValue);
	}

	private static void buttonClickByName(WebDriver wd, String elementName) {
		wd.findElement(By.name(elementName)).click();
	}

	private static void buttonClickByXpath(WebDriver wd, String xpath) {
		wd.findElement(By.xpath(xpath)).click();
		// "//a[text()='Flights']"
	}
	private static void selectRadioButton(WebDriver wd, String name) {
		
	}
}
//List<WebElement> oColList = oRow.findElements(By.xpath("//div[@class='cb-col cb-col-16 cb-rank-tbl cb-font-16']"));
//for (int j = 0; j < oColList.size(); j++) {
//	oCell = oColList.get(j);
//	System.out.print(oCell.getText()+"  ");
//}
//System.out.println();
