package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import myAdapter.StackAdapter;
/**
 * TestSize class
 */
public class TestSize {
	
	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter threeStack;
	
	/**
	 * TestSize setUp
	 */
	@Before
	public void setUp(){
		emptyStack = new StackAdapter();
		
		oneStack = new StackAdapter();
		oneStack.push("asso");
		
		threeStack = new StackAdapter();
		threeStack.push("jack");
		threeStack.push("queen");
		threeStack.push("king");
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.size method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the size() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the size method returns the number of the elements in this StackAdapter.
	 * If this list contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * threeStack contains three elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The StackAdapter hasn't changed.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't changed, no exception is thrown.
	 */
	@Test
	public void testSize() {
		assertTrue(emptyStack.isEmpty());
		emptyStack.push("something");
		assertEquals(1, emptyStack.size());
		
		assertEquals(1, oneStack.size());
		oneStack.push("something");
		assertEquals(2, oneStack.size());
		
		assertEquals(3, threeStack.size());
		threeStack.push("something");
		assertEquals(4, threeStack.size());
	}

}
