package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestContains  class
 */
public class TestContains {
	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestContains setUp
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
	 * Test StackAdapter.contains method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the contains() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the contains method returns true if this StackAdapter contains the specified element, false otherwise. 
	 * More formally, returns true if and only if this list contains at least one element e such that {@code(o==null ? e==null : o.equals(e))}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * An int index is returned from the method.
	 * The StackAdapter hasn't changed due to the contains method.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't been modified by the contains() method, no exception is thrown.
	 */
	@Test
	public void testContains() {
		assertFalse(emptyStack.contains("something"));
		assertFalse(emptyStack.contains(null));
		assertFalse(emptyStack.contains(oneStack));
		assertTrue(oneStack.contains("asso"));
		assertFalse(oneStack.contains("something"));
		for(int i = 0; i < 100; i++) {
			assertTrue(longStack.contains(i));
		}
		longStack.clear();
		for(int i = 0; i < 100; i++) {
			longStack.push("same");
		}
		assertTrue(longStack.contains("same"));
	}

}
