package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;
import myAdapter.StackAdapter;
/**
 * TestPop class
 */
public class TestPop {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestPop setUp
	 */
	@Before
	public void setUp(){
		emptyStack = new StackAdapter();
		
		oneStack = new StackAdapter();
		oneStack.push("asso");
		
		longStack = new StackAdapter();
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.pop method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the pop() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the pop method return value is the object on top of this StackAdapter and then removes it from the StackAdapter.
	 * The StackAdapter needs to be not empty.
	 * 
	 * <h4>Pre-Condition</h4>
	 * This StackAdapter needs to be constructed properly (not empty).
	 * 
	 * <h4>Post-Condition</h4>
	 * The object on the top of this stack is returned and removed from the StackAdapter.
	 * The StackAdapter size is decreased by 1.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter has decreased its size by 1, no exception is thrown.
	 */
	@Test
	public void testPop() {
		oneStack.pop();
		assertEquals(emptyStack, oneStack);
		for(int i = 0; i < 100; i++) {
			longStack.push("jolly");
			assertEquals(longStack.size(), 1);
			longStack.pop();
			assertEquals(longStack.size(), 0);
		}
		assertTrue(longStack.isEmpty());
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.pop method when the StackAdapter is empty
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the pop() method of the StackAdapter,
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the pop method return value is the object on top of this StackAdapter and then removes it from the StackAdapter.
	 * The StackAdapter needs to be not empty.
	 * 
	 * <h4>Pre-Condition</h4>
	 * None.
	 * 
	 * <h4>Post-Condition</h4>
	 * No object is returned, an EmptyStackException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * No object is returned.
	 * An EmptyStackException is thrown.
	 */
	@Test(expected=EmptyStackException.class)
	public void testPopEmptyStackException() {
		emptyStack.pop();
	}
	
}
