package generic;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Result implements ITestListener,IautoConst{
	int Passcount=0,Failcount=0;
	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(Passcount+":passcount and failcount is:"+Failcount+"",true);
		utility.WriteResult(SUMMARY_PATH, "sheet1",Passcount,Failcount);	
	}
	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void onTestFailure(ITestResult arg0) {
		Failcount++;	
	}
	@Override
	public void onTestSuccess(ITestResult arg0) {
		Passcount++;	
	}
	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub	
	}

}
