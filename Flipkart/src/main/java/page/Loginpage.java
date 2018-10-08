package page;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import util.*;
public class Loginpage {
   WebDriver wd;
   Properties prop;
   public Loginpage(WebDriver wd, Properties prop) {
	   this.wd = wd;
	   this.prop = prop;  
   }
   private void  setUserName() {
	   TestUtil.textBoxSelectionClass(wd, "_2zrpKA", prop.getProperty("username"));
   }
   private void  setPassword() {
	   TestUtil.textBoxSelectionXpath(wd, "//input[@type=\"password\"]", prop.getProperty("pswd"));
   }
   private void clickLogin() {
	   TestUtil.buttonClickByXpath(wd, "//div[@class='_1avdGP']//button[@type='submit']");
   }
   public void loginToFlipkart() {
	   setUserName();
	   setPassword();
	   clickLogin();
   }

}
