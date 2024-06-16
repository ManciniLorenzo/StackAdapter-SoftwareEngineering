package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestClear class
 */
public class TestClear {
	
	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestClear setUp
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
	 * Test StackAdapter.clear method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the clear() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the clear method removes all of the elements from this StackAdapter. 
	 * This list will be empty after this call returns (unless it throws an exception).
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * 
	 * <h4>Post-Condition</h4>
	 * After the call to clear() method, all of the elements are removed from this StackAdapter.
	 * The size of this StackAdapter is setted to 0.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter is empty and its size is equal to zero, no exception is thrown.
	 */
	@Test
	public void testClear() {
		emptyStack.clear();
		assertTrue(emptyStack.isEmpty());
		
		oneStack.clear();
		assertTrue(oneStack.isEmpty());
		
		oneStack.add("uno");
		assertFalse(oneStack.isEmpty());
		oneStack.clear();
		assertTrue(oneStack.isEmpty());
		
		assertFalse(longStack.isEmpty());
		assertEquals(longStack.size(), 100);
		longStack.clear();
		assertNotEquals(longStack.size(), 100);
		assertTrue(longStack.isEmpty());
	}

}
