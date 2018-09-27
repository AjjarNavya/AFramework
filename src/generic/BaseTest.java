package generic;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
@Listeners(Result.class)
public  abstract class BaseTest implements IautoConst {	
//  @Test
//  public void f() {
//  }
	public WebDriver driver;//if u make webdriver as static we cant run grid 
	public String url=utility.getPropertyValue(CONFIG_PATH, "URL");
	 String ITO=utility.getPropertyValue(CONFIG_PATH, "ITO");//solution2
	public long duration=Long.parseLong(ITO);
//	public static final String Chrome_key="Webdriver.chrome.driver";//final because i dont want to change it
//	public static final String Gecko_key="Webdriver.gecko.driver";//static because static can access static member
//	
//	public static final String Chrome_value="./driver/chromedriver.exe";
//	public static final String Gecko_value="./driver/geckodriver.exe";
	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE );
		System.setProperty(GECKO_DRIVER, GECKO_VALUE);
	}
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log("inside beforemethod",true);
	  driver= new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);//solution 110, TimeUnit.SECONDS);
	  driver.get(url);
  }
  @AfterMethod
  public void afterMethod() {
	  Reporter.log("inside aftermethod",true);
	  
	  driver.close();
	 
  }

}
