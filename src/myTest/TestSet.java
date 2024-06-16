package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestSet class
 */
public class TestSet {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter threeStack;
	
	/**
	 * TestSet setUp
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
	 * Test StackAdapter.set method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the set(int, Object) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the set method replaces the element at the specified position with the specified element.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * After the call to set() method the specified element is added to this StackAdapter and the list size is increased by one.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The specified element is added to this StackAdapter and the list size is increased by one, no exception is thrown.
	 */
	@Test
	public void testSet() {
		emptyStack.add(null);
		assertEquals(emptyStack.set(0, "asso"), null);
		assertEquals("asso", oneStack.set(0, "jack"));
		assertEquals(oneStack.get(0), threeStack.get(0));
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.set method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the set(int, Object) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the set method replaces the element at the specified position with the specified element.
	 * In particular if the index is out of range {@code(index < 0)}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to set() method fails and this StackAdapter hasn't changed.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to set() method fails and this StackAdapter hasn't changed, IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetIndexOutOfBoundsException1() {
		emptyStack.set(-1, null);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.set method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the set(int, Object) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the set method replaces the element at the specified position with the specified element.
	 * In particular if the index is out of range {@code(index >= size())}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to set() method fails and this StackAdapter hasn't changed.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to set() method fails and this StackAdapter hasn't changed, IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSetIndexOutOfBoundsException2() {
		emptyStack.set(emptyStack.size(), null);
	}

}
