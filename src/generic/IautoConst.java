package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public interface IautoConst {
	 
	public static final String CHROME_KEY="Webdriver.chrome.driver";//final because i dont want to change it
	public static final String GECKO_DRIVER="Webdriver.gecko.driver";//static because static can access static member
	
	public static final String CHROME_VALUE="./driver/chromedriver.exe";
	public static final String GECKO_VALUE="./driver/geckodriver.exe";
	
    String CONFIG_PATH="./config.properties";
    String SUMMARY_PATH ="./Result/Summary.xlsx";
    String INPUT_PATH="./data/Input.xlsx";
    String PHOTO_PATH="./photo";
    
}
