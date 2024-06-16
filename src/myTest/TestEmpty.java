package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestEmpty class
 */
public class TestEmpty {
	
	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;

	/**
	 * TestEmpty setUp
	 */
	@Before
	public void setUp(){
		emptyStack = new StackAdapter();
		
		oneStack = new StackAdapter();
		oneStack.push("asso");
		
		longStack = new StackAdapter();
		for(int i = 0; i < 100; i++) {
			longStack.push(i);
		}
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.empty method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the empty() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the StackAdapter is empty.
	 * 
	 * <h4>Pre-Condition</h4>
	 * None.
	 * 
	 * <h4>Post-Condition</h4>
	 * The StackAdapter hasn't changed, no exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't changed, no exception is thrown.
	 */
	@Test
	public void testEmpty() {
		assertTrue(emptyStack.empty());
		emptyStack.push("something");
		assertFalse(emptyStack.empty());
		
		assertFalse(oneStack.empty());
		oneStack.clear();
		assertTrue(oneStack.empty());
		
		assertFalse(longStack.empty());
		longStack.clear();
		assertTrue(longStack.empty());
	}

}
