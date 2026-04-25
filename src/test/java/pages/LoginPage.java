package pages;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Context.TestContext;
import Managers.PageObjectManager;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 wait=new WebDriverWait(driver,java.time.Duration.ofSeconds(10));
	}
	
	@FindBy(id="customer_email")
	WebElement usernameField;
	
	@FindBy(id="customer_password")
	WebElement passwordField;
	
	@FindBy(id="customer_login_link")
	WebElement loginBtn;
	
	@FindBy (xpath="//*[@id=\"customer_login\"]/div[5]/input")
	WebElement signInBtn;
	
	
	public void clickOpenLoginPage() throws InterruptedException {
		Thread.sleep(3000);
//		loginBtn.click();
		wait.until(ExpectedConditions.visibilityOf(loginBtn)).click();
	}
	
	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickSignInBtn() {
		signInBtn.click();
	}

}
