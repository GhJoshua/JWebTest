
// 根据 Python版 web selenium automation框架改成Java版

package test.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.opera.*;

/** This class is the BasePage containing web element operations
 * 	@author Joshua
 * @version 1.0
 * */
public class BasePage {
	WebDriver driver;
	
	/**
	* webdriver instance
	* @param browser using all lower characters, 
	*  support "chrome", 'Internet explorer", "firefox", "opera"
	 * @throws Exception 
	*/
	public BasePage(String browser) throws Exception {
		try {
			if (browser == "firefox" || browser == "ff") {
				driver = new FirefoxDriver();
			} else if (browser.contentEquals("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".\\ExternalLib\\chromedriver.exe");
	            driver = new ChromeDriver();
			} else if (browser == "internet explorer" || browser == "ie") {
	            driver = new InternetExplorerDriver();
			} else if (browser == "opera") {
	            driver = new OperaDriver();
			}             
        }
        catch (Exception e)
        {
        	throw new Exception(e.getMessage());
            //throw ("Not found %s browser,You can enter 'ie', 'ff' or 'chrome'."  + browser);
        }
    }
	
	/*
	 * Find element
	 * element is a set with format (identifier type, value), e.g. ('id','username') 
	 * Usage: findElement(element)
	 */
	public WebElement findElement(String[] element) {
		WebElement elem = null;
		try {
            String type = element[0];
            String value = element[1];
            if (type == "id" || type == "ID" || type=="Id") {
                elem = driver.findElement(By.id(value));
            }
           else if (type == "name" || type == "NAME" || type=="Name") {
                elem = driver.findElement(By.name(value));
           }
           else if (type == "class" || type == "CLASS" || type=="Class") {
                elem = driver.findElement(By.className(value));
           }
           else if (type == "link_text" || type == "LINK_TEXT" || type=="Link_text") {
                elem = driver.findElement(By.linkText(value));
           }
           else if (type == "xpath" || type == "XPATH" || type=="Xpath") {
                elem = driver.findElement(By.xpath(value));
           }
           else if (type == "css" || type == "CSS" || type=="Css") {
                elem = driver.findElement(By.cssSelector(value));
           } else {
                // throw ("Please correct the type in function parameter");
           }
		} 
		catch (Exception e) {
			// throw ("No such element found"+ str(element));
		}
       return elem;
	}

	/**
	 * Open web url	 * 
	 * Usage: open(url)
	 */
	public void open(String url) {
        if (url != "") {
            driver.get(url);
        } else {
            // throw("please provide a base url");
        }
	}
	/**
	 * Operation input box.
	 * Usage: type(element,text)
	 */
    public void type(WebElement element, String text) {
        element.sendKeys(text);
    } 
    /**Keyboard: hit return
     * Usage: enter(element)
    */
    public void enter(WebElement element) {
        element.sendKeys(Keys.RETURN);
    }
    public void click(WebElement element) {
        element.click();
    }
    /**
     * close and quit the window
     * */
    public void quit() {
        driver.quit();
    }
    public String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }
    public String getText(WebElement element) {
        return element.getText();
    }
    public String getTitle() {
        return driver.getTitle();
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public void getScreenshot(String targetpath) {
        //driver.manage().window().
    }
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
    public void back() {
        driver.navigate().back();
    }
    public void forward() {
        driver.navigate().forward();
    }
    public Dimension getWindowSize() {
        return driver.manage().window().getSize();
    }
    public void refresh() {
        driver.navigate().refresh();
    }
}
