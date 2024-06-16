package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import myAdapter.StackAdapter;
/**
 * TestIsEmpty class
 */
public class TestIsEmpty {
	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestIsEmpty setUp
	 */
	@Before
	public void setUp(){
		emptyStack = new StackAdapter();
		
		oneStack = new StackAdapter();
		oneStack.push("asso");
		
		longStack = new StackAdapter();
		for (int i = 0; i < 100; i++) {
			longStack.push(i);
		}
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.isEmpty method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the isEmpty() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the StackAdapter contains no element.
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
	public void testIsEmpty() {
		assertTrue(emptyStack.isEmpty());
		emptyStack.push("something");
		assertFalse(emptyStack.isEmpty());
		
		assertFalse(oneStack.isEmpty());
		oneStack.clear();
		assertTrue(oneStack.isEmpty());
		
		assertFalse(longStack.isEmpty());
		longStack.clear();
		assertTrue(longStack.isEmpty());
	}

}
