package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestRetainAll class
 */
public class TestRetainAll {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestRetainAll setUp
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
	 * Test StackAdapter.retainAll method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the retainAll(HCollection) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the retainAll method retains only the elements in this StackAdapter that are contained in the specified collection. 
	 * In other words, removes from this list all the elements that are not contained in the specified collection.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * After the call to retainAll() method, all of the elements that are not contained in the specified collection are removed from this StackAdapter.
	 * The size of this StackAdapter decreases by the number of elements that are not contained in the specified collection are removed from this StackAdapter.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter retains only the elements present in the specified collection, no exception is thrown.
	 */
	@Test
	public void testRetainAll() {
		assertTrue(longStack.retainAll(oneStack));
		assertEquals(longStack, oneStack);
		
		assertFalse(emptyStack.retainAll(oneStack));
		
		assertTrue(oneStack.retainAll(emptyStack));
		assertEquals(emptyStack, oneStack);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.retainAll method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the retainAll(HCollection) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the retainAll method retains only the elements in this StackAdapter that are contained in the specified collection. 
	 * In other words, removes from this list all the elements that are not contained in the specified collection.
	 * In particular if the specified collection is null.
	 * 
	 * <h4>Pre-Condition</h4>
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to retainAll() method fails and the StackAdapter hasn't changed.
	 * NullPointerException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter retains only the elements present in the specified collection, no exception is thrown.
	 */
	@Test(expected=NullPointerException.class)
	public void testRetainAllNullPointerException() {
		longStack.retainAll(null);
	}

}
