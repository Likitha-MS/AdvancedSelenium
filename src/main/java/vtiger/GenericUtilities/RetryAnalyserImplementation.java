package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for IRetryAnalyser interface of TestNG
 * @author LIKITHA
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer{


	int count = 0;
	int retryCount = 2;
	
	public boolean retry(ITestResult result) {
		while(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

	
}
