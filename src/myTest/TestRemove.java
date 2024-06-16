package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestRemove class
 */
public class TestRemove {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestRemove setUp
	 */
	@Before
	public void setUp(){
		emptyStack = new StackAdapter();
		
		oneStack = new StackAdapter();
		oneStack.push("asso");
		
		longStack = new StackAdapter();
		for(int i = 0; i < 100; i++) {
			longStack.push(i);
		}
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.remove method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the remove(Object) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the remove method removes the first occurrence in this StackAdapter of the specified element. 
	 * If this StackAdapter does not contain the element, it is unchanged. 
	 * More formally, removes the element with the lowest index i such that {@code(o==null ? get(i)==null : o.equals(get(i)))} (if such an element exists).
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The StackAdapter decreases its size by one after the call to remove() method.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * Regardless its previous size, the StackAdapter has decreased its size due to the remove() method, no exception is thrown.
	 */
	@Test
	public void testRemoveObject() {
		assertNotEquals(emptyStack.size(), oneStack.size());
		oneStack.remove("asso");
		assertEquals(emptyStack, oneStack);
		assertEquals(emptyStack.size(), oneStack.size());
		assertFalse(emptyStack.remove("something"));
		
		assertEquals(longStack.size(), 100);
		for(int i = 0; i < longStack.size(); i++) {
			assertEquals(longStack.size(), 100 - i);
			longStack.remove(i);
			assertEquals(longStack.size(), 99 - i);
		}
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.remove method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the remove(int) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the add method removes the element at the specified position in this list. 
	 * Shifts any subsequent elements to the left (subtracts one from their indices). 
	 * Returns the element that was removed from the list.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The StackAdapter decreases its size by one after the call to remove() method.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * Regardless its previous size, the StackAdapter has decreased its size due to the remove() method, no exception is thrown.
	 */
	@Test
	public void testRemoveIndex() {
		assertNotEquals(emptyStack.size(), oneStack.size());
		oneStack.remove(0);
		assertEquals(emptyStack, oneStack);
		assertEquals(emptyStack.size(), oneStack.size());
		
		longStack.clear();
		oneStack.add("primo");
		longStack.add("secondo");
		longStack.add("primo");
		longStack.remove(0);
		assertEquals(oneStack, longStack);
	}

	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.remove method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the remove(int) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the add method removes the element at the specified position in this list. 
	 * Shifts any subsequent elements to the left (subtracts one from their indices). 
	 * Returns the element that was removed from the list.
	 * In particular if the index is out of range {@code(index < 0)}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to remove() method fails and the StackAdapter hasn't changed its size.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to remove() method fails and the StackAdapter hasn't changed its size.
	 * IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemoveIndexOutOfBoundsException1() {
		emptyStack.remove(-1);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.remove method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the remove(int) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the add method removes the element at the specified position in this list. 
	 * Shifts any subsequent elements to the left (subtracts one from their indices). 
	 * Returns the element that was removed from the list.
	 * In particular if the index is out of range {@code(index >= size())}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to remove() method fails and the StackAdapter hasn't changed its size.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to remove() method fails and the StackAdapter hasn't changed its size.
	 * IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemoveIndexOutOfBoundsException2() {
		emptyStack.remove(10);
	}
}
