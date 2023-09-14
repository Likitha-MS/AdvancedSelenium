package vtiger.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class will provide implementation to ITestListener interface
 * @author LIKITHA
 */
public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" ==== Test script execution started ====");
		
		//create a test in extent report
		test = report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		//System.out.println(methodname+" ==== PASS ====");
		
		test.log(Status.PASS, methodname+" ==== PASS ====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//to take screen shot
		WebDriverUtility wUtil =  new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		String methodname = result.getMethod().getMethodName();
		String screenshotName = methodname+jUtil.getSystemDate();
		
		System.out.println(result.getThrowable()); //prints reason of exception
		//System.out.println(methodname+" ==== FAIL ====");
		
		test.log(Status.FAIL, methodname+" ==== FAIL ====");
		test.log(Status.INFO, result.getThrowable());
		
		try {
			String path = wUtil.captureScreenShot(BaseClass.sdriver, screenshotName);
			//attach screenshot into the report
			test.addScreenCaptureFromPath(path);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getThrowable()); //prints reason of exception
		String methodname = result.getMethod().getMethodName();
		//System.out.println(methodname+" ==== SKIP ====");
		
		test.log(Status.SKIP, methodname+" ==== SKIP ====");
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==== Suite execution started ====");
		
		//configure the extent reports
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		htmlreport.config().setDocumentTitle("Vtiger Execution Report");
		htmlreport.config().setReportName("Automation execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "firefox");
		report.setSystemInfo("Base url", "https://localhost:8888");
		report.setSystemInfo("Reporter Name", "Likitha");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("==== Suite execution ended ====");
		//will generate report fter execution
		report.flush();
	}

	
}
