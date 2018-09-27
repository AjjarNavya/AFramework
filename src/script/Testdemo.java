package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.utility;

public class Testdemo extends BaseTest {
	
	@Test
	public void Testingmethod()
	{
	String data =utility.getXLdata(INPUT_PATH, "Sheet1", 0, 0);
	Reporter.log("DATA:"+data,true);	
	int r=utility.getXlrowcount(INPUT_PATH, "sheet1");
	Reporter.log("Row:"+r,true);
	String p=utility.Getphoto(driver, PHOTO_PATH);
	Reporter.log("DATA:"+data,true);
	
	}
	
	

}
