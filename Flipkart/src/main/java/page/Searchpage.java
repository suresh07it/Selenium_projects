package page;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ExcelDataDriven;
import util.TestUtil;

public class Searchpage {

	WebDriver wd;
	Properties prop;
	String excelFile;
	String sheetName;

	public Searchpage(WebDriver wd, Properties prop,String excelFile,String sheetName ) {
		this.wd = wd;
		this.prop = prop;
		this.excelFile = excelFile;
		this.sheetName = sheetName;
	}
	
	public void searchAndAddCart() {
		List<String> searchItems = ExcelDataDriven.readAllValuesFromExcel(excelFile, sheetName);
		String textValue;
		for(String searchItem : searchItems) {
			System.out.println(searchItem);
			TestUtil.textBoxSelectionClass(wd, "LM6RPg", searchItem);
			TestUtil.buttonClickByXpath(wd,"//button[@type='submit']");
			String windowHandle = wd.getWindowHandle();
			List<WebElement> elementLists = TestUtil.getListofElementsFromClass(wd, "_3wU53n");
			for(WebElement wb: elementLists) {
				 textValue = wb.getText();
				 if(textValue.equalsIgnoreCase(searchItem)) {
					 wb.click();
					 Set<String> windowHandles = wd.getWindowHandles();
					 for(String s :windowHandles) {
						 if(!s.equals(windowHandle))
						 wd.switchTo().window(s);
					 }
					 WebElement divCart = TestUtil.getListofElementFromClass(wd,"_3QNwd7");
					 WebElement cart = divCart.findElement(By.className("_3oJBMI"));
					 cart.click(); break;
				 }
			}
			
		}
	}
}
