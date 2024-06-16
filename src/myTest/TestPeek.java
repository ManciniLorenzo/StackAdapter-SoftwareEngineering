package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestPeek class
 */
public class TestPeek {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestPeek setUp
	 */
	@Before
	public void setUp(){
		emptyStack = new StackAdapter();
		
		oneStack = new StackAdapter();
		oneStack.push("jolly");
		
		longStack = new StackAdapter();
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.peek method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the peek() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the peek method return value is the object on top of this StackAdapter.
	 * The StackAdapter needs to be not empty.
	 * 
	 * <h4>Pre-Condition</h4>
	 * This StackAdapter needs to be constructed properly (not empty).
	 * 
	 * <h4>Post-Condition</h4>
	 * The object on the top of this StackAdapter is returned by the method.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't changed, no exception is thrown.
	 */
	@Test
	public void testPeek() {
		assertEquals(oneStack.peek(), "jolly");
		for(int i = 0; i < 100; i++) {
			longStack.push(i);
			assertEquals(longStack.peek(), i);
		}
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.push method on an empty StackAdapter
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the peek() method of the StackAdapter when called on an empty StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the peek method return value is the object on top of this StackAdapter.
	 * The StackAdapter needs to be not empty.
	 * 
	 * <h4>Pre-Condition</h4>
	 * None.
	 * 
	 * <h4>Post-Condition</h4>
	 * No object is returned by the method.
	 * An IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter hasn't changed.
	 * An IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testPeekIndexOutOfBoundsException() {
		emptyStack.peek();
	}

}
