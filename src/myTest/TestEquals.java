package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestEquals class
 */
public class TestEquals {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestEquals setUp
	 */
	@Before
	public void setUp(){
		emptyStack = new StackAdapter();
		
		oneStack = new StackAdapter();
		oneStack.push(1);
		
		longStack = new StackAdapter();
		for(int i = 0; i < 100; i++) {
			longStack.push(i);
		}
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.equals method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the equals() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the equals method compares the specified object with this list for equality. 
	 * Returns true if and only if the specified object is also a list, both lists have the same size, and all corresponding pairs of elements in the two lists are equal. 
	 * (Two elements e1 and e2 are equal {@code if(e1==null ? e2==null : e1.equals(e2))})
	 * In other words, two lists are defined to be equal if they contain the same elements in the same order.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The StackAdapter isn't affected by the call to equals() method.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter isn't affected by the call to equals() method, no exception is thrown.
	 */
	@Test
	public void testEquals() {
		assertFalse(emptyStack.equals(null));
		assertFalse(oneStack.equals(null));
		assertFalse(longStack.equals(null));

		assertTrue(emptyStack.equals(emptyStack));
		assertTrue(oneStack.equals(oneStack));
		assertTrue(longStack.equals(longStack));
		
		assertFalse(emptyStack.equals(oneStack));
		assertFalse(emptyStack.equals(longStack));
		assertFalse(oneStack.equals(longStack));
		
		longStack.clear();
		assertTrue(emptyStack.equals(longStack));
		longStack.add(1);
		assertTrue(oneStack.equals(longStack));
		longStack.add(null);
		assertFalse(oneStack.equals(longStack));
		assertFalse(longStack.equals(oneStack));
		oneStack.add(null);
		assertTrue(oneStack.equals(longStack));
		assertTrue(longStack.equals(oneStack));
	}

}
