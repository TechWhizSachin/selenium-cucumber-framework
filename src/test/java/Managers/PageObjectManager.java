package Managers;

import org.openqa.selenium.WebDriver;

import pages.LoginPage;

public class PageObjectManager {
	WebDriver driver;
	
	LoginPage loginPage;
	
	  public PageObjectManager(WebDriver driver) {
	        this.driver = driver;
	    }

	
	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage=new LoginPage(driver);
		}
		return loginPage;
	}
}
