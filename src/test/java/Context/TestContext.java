package Context;

import org.openqa.selenium.WebDriver;

import Managers.PageObjectManager;

public class TestContext {
private WebDriver driver;
private PageObjectManager pageObjectManager;

public PageObjectManager getPageObjectManager() {
    if (pageObjectManager == null) {
        pageObjectManager = new PageObjectManager(driver);
    }
    return pageObjectManager;
}

public void setDriver(WebDriver driver) {
	this.driver=driver;
}

public WebDriver getDriver() {
	return this.driver;
}
	
}
