package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class CommonMethod {
	
	private static final long DEFAULT_WAIT = 100;
	protected WebDriver driver;
	 protected WebDriverWait smartWait;
	
	public CommonMethod(WebDriver driver) {
		this.driver = driver;
		this.smartWait = new WebDriverWait(driver, DEFAULT_WAIT);
	}
	
	/**
     * Alert accept
     **/
    public void popupOk() {
        Alert al = driver.switchTo().alert();
        System.out.println("Alert text:" + al.getText());
        al.accept();
    }
	
	/**
     * Action class double click
	 * @throws InterruptedException 
     **/
    public void doubleClick(By element) throws InterruptedException {
        Actions action = new Actions(driver);
	    WebElement ele = driver.findElement(element);
	    action.doubleClick(ele);
	    action.perform();   
    }
    
    /**
     * SikuliX click
     * @throws FindFailed 
     **/
    public void sikuliClick(String imagePath) throws FindFailed {
    	Screen sc = new Screen();
    	sc.click("imagePath");
    }
    
    /**
     * Switch window
     **/
    public void switchWindow()  {
    	String parentWin = driver.getWindowHandle();
    	// Do some action to invoke the tab or new window    	
    	for(String winHandle : driver.getWindowHandles()) {
    		driver.switchTo().window(winHandle);
    	}
//    	do something on the new window
    	driver.switchTo().window(parentWin);
    }

}
