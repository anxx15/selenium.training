package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethod {
	
	private static final long DEFAULT_WAIT = 100;
	protected WebDriver driver;
	 protected WebDriverWait smartWait;
	
	public CommonMethod(WebDriver driver) {
		this.driver = driver;
		this.smartWait = new WebDriverWait(driver, DEFAULT_WAIT);
	}
}
