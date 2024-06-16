package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestContainsAll class
 */
public class TestContainsAll {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestContainsAll setUp
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
	 * Test StackAdapter.containsAll method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the containsAll(HCollection) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the containsAll method returns true if this list contains all of the elements of the specified collection.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack is empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The StackAdapter hasn't changed after the call to containsAll() method.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't been modified, no exception is thrown.
	 */
	@Test
	public void testContainsAll() {
		assertTrue(longStack.containsAll(oneStack));
		assertTrue(longStack.containsAll(emptyStack));
		assertFalse(emptyStack.containsAll(longStack));
		
		oneStack.add(null);
		assertFalse(longStack.containsAll(oneStack));
		longStack.add(null);
		assertTrue(longStack.containsAll(oneStack));
		longStack.remove(null);
		assertFalse(longStack.containsAll(oneStack));
		
		StackAdapter fakeStack = new StackAdapter(oneStack);
		assertTrue(oneStack.containsAll(fakeStack));
		assertTrue(fakeStack.containsAll(oneStack));
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.containsAll method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the containsAll(HCollection) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the add method returns true if this list contains all of the elements of the specified collection.
	 * In particular if the specified collection is null.
	 * 
	 * <h4>Pre-Condition</h4>
	 * oneStack contains only one element.
	 * 
	 * <h4>Post-Condition</h4>
	 * The StackAdapter hasn't changed after the call to containsAll() method.
	 * NullPointerException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The containsAll method fails and the StackAdapter hasn't been modified, NullPointerException is thrown.
	 */
	@Test(expected=NullPointerException.class)
	public void testContainsAllNullPointerException() {
		oneStack.containsAll(null);
	}

}
