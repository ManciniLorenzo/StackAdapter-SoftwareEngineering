package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestRemoveAll class
 */
public class TestRemoveAll {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestRemoveAll setUp
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
	 * Test StackAdapter.removeAll method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the removeAll(HCollection) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the removeAll method removes from this StackAdapter all the elements that are contained in the specified collection.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * After the call to removeAll() method, all of the elements in the parameter collection are removed from this StackAdapter.
	 * The size of this StackAdapter decreases by the number of elements of the specified collection that are contained in this StackAdapter.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The specified collection is removed from this StackAdapter, no exception is thrown.
	 */
	@Test
	public void testRemoveAll() {
		assertTrue(longStack.removeAll(oneStack));
		oneStack.clear();
		oneStack.add("asso");
		assertFalse(longStack.removeAll(oneStack));
		assertFalse(oneStack.removeAll(emptyStack));
		assertFalse(emptyStack.removeAll(oneStack));
		assertNotEquals(emptyStack, oneStack);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.removeAll method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the removeAll(HCollection) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the removeAll method removes from this StackAdapter all the elements that are contained in the specified collection.
	 * In particular if the specified collection is null.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * After the call to removeAll() method, all of the elements in the parameter collection are removed from this StackAdapter.
	 * The size of this StackAdapter decreases by the number of elements of the specified collection that are contained in this StackAdapter.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The specified collection is removed from this StackAdapter, no exception is thrown.
	 */
	@Test(expected=NullPointerException.class)
	public void testRemoveAllNullPointerException() {
		longStack.removeAll(null);
	}

}
