package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestPush class
 */
public class TestPush {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestPush setUp
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
	 * Test StackAdapter.push method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the push() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the object passed as a parameter is added on top of this StackAdapter.
	 * The HCollection object passed as a parameter needs to be not null.
	 * 
	 * <h4>Pre-Condition</h4>
	 * This StackAdapter needs to be constructed properly.
	 * 
	 * <h4>Post-Condition</h4>
	 * The object is pushed onto the top of this stack.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter top object is the item passed as parameter, no exception is thrown.
	 */
	@Test
	public void testPush() {
		emptyStack.push("asso");
		assertEquals(emptyStack, oneStack);
		
		assertEquals(longStack.size(), 0);
		for(int i = 0; i < 100; i++) {
			assertEquals(longStack.size(), i);
			longStack.push(i);
			assertEquals(longStack.get(i), i);
			assertEquals(longStack.size(), i + 1);
		}
		assertEquals(longStack.get(0), 0);
		assertEquals(longStack.get(99), 99);
	}

}
