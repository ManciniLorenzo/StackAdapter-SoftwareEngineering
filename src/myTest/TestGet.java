package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestGet class
 */
public class TestGet {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter threeStack;
	
	/**
	 * TestGet setUp
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
	 * Test StackAdapter.get method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the get() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the get method returns the element at the specified position in this list.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The StackAdapter isn't affected by the call to get() method.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The StackAdapter isn't affected by the call to get() method, no exception is thrown.
	 */
	@Test
	public void testGet() {
		assertEquals(oneStack.get(0), "asso");
		
		assertEquals(threeStack.get(0), "jack");
		assertEquals(threeStack.get(1), "queen");
		assertEquals(threeStack.get(2), "king");
		
		emptyStack.add(null);
		assertNull(emptyStack.get(0));
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.get method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the get() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the get method returns the element at the specified position in this list.
	 * In particular if the index is out of range {@code(index < 0)}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to get() method fails, no object is returned.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to get() method fails, no object is returned, IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetIndexOutOfBoundsException1() {
		emptyStack.get(-1);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.get method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the get() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the get method returns the element at the specified position in this list.
	 * In particular if the index is out of range {@code(index >= size())}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to get() method fails, no object is returned.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to get() method fails, no object is returned, IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetIndexOutOfBoundsException2() {
		oneStack.get(oneStack.size() + 1);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.get method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the get() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the get method returns the element at the specified position in this list.
	 * In particular if the index is out of range {@code(index >= size())}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to get() method fails, no object is returned.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to get() method fails, no object is returned, IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetIndexOutOfBoundsException3() {
		emptyStack.get(0);
	}
}
