package myTest;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
/**
 * TestRunner class
 */
public class TestRunner {

	public static void main(String[] args) {
		System.out.println("Running StackAdapterTestSuite");
		Result result = JUnitCore.runClasses(StackAdapterTestSuite.class);
		
		System.out.println("Executed " + result.getRunCount() + " tests");
		
		if(result.wasSuccessful()) {
			System.out.println("All the tests were completed successfully.");
			return;
		}
		System.out.println(result.getFailureCount() + " tests failed of " + result.getRunCount());
		List<Failure> failedTests = result.getFailures();
		for(int i = 0; i < failedTests.size(); i++) {
			System.out.println("\n------test failed: ");
			System.out.println("\nHeader: " + failedTests.get(i).getTestHeader());
			System.out.println("\nTrace: " + failedTests.get(i).getTrimmedTrace());
			if(failedTests.get(i).getMessage() != null) System.out.println("\nMessage: " + failedTests.get(i).getMessage());
		}
	}

}
