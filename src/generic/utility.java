package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utility {

	public static String getPropertyValue(String path,String key)
	{
		String v="";
		try {
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return v;
	}
	public static void WriteResult(String path,String sheet,int passcount,int failcount)
	 {
		 try
		 {
			 Workbook  wb= WorkbookFactory.create(new FileInputStream(path));
			 wb.getSheet("sheet1").getRow(1).getCell(0).setCellValue(passcount);
			 wb.getSheet("sheet1").getRow(1).getCell(1).setCellValue(failcount);
			 wb.write(new FileOutputStream(path));
			 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }
	public  static String getXLdata(String path,String Sheet,int r,int c)
	{
		String v="";
		try
		{
			Workbook w=WorkbookFactory.create(new FileInputStream(path));
			v=w.getSheet(Sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e) {
			e.printStackTrace();
			
	}
		return v;
	 }
	public static int getXlrowcount(String path,String sheet)
	{
		int count=0;
	try
	{
		Workbook w=WorkbookFactory.create(new FileInputStream(path));
		count= w.getSheet(sheet).getLastRowNum();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		return count;
		
	}

    public static String Getphoto(WebDriver driver ,String folder )
    {
    	Date d=new Date();
    	String Datatime=d.toString().replaceAll(":", "_");
    	String path=folder+"/"+Datatime+".png";
    	try
    	{
    		TakesScreenshot t=(TakesScreenshot)driver;
    		File srcFile=t.getScreenshotAs(OutputType.FILE);
    		File destFile=new File(path);
    		FileUtils.copyFile(srcFile,destFile);
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return path;
    }
}
