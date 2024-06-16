package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.*;
/**
 * TestListIterator class
 */
public class TestListIterator {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestListIterator setUp
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
	 * Test StackAdapter.listIterator method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the listIterator() method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the listIterator method returns a HListIterator of the elements in this StackAdapter (in proper sequence).
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * After the call to listIterator() method this StackAdapter hasn't changed.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * After the call to listIterator() method this StackAdapter hasn't changed, an iterator over this StackAdapter is returned.
	 * No exception is thrown.
	 */
	@Test
	public void testListIterator() {
		HListIterator iter = emptyStack.listIterator();
		assertFalse(iter.hasPrevious());
		assertFalse(iter.hasNext());
		
		HListIterator it = longStack.listIterator();
		for(int i = 0; i < 100; i++) {
			assertTrue(it.hasNext());
			assertEquals(i, it.next());
		}
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.listIterator method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the listIterator(int) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the listIterator method returns a list iterator of the elements in this StackAdapter (in proper sequence), starting at the specified position in this StackAdapter. 
	 * The specified index indicates the first element that would be returned by an initial call to the next method. 
	 * An initial call to the previous method would return the element with the specified index minus one.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * After the call to listIterator(int) method this StackAdapter hasn't changed.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * After the call to listIterator(int) method this StackAdapter hasn't changed, an iterator over this StackAdapter is returned.
	 * No exception is thrown.
	 */
	@Test
	public void testListIteratorParam() {
		HListIterator iter = emptyStack.listIterator(0);
		assertFalse(iter.hasPrevious());
		assertFalse(iter.hasNext());
		
		HListIterator it = longStack.listIterator(50);
		for(int i = 0; i < 50; i++) {
			assertTrue(it.hasNext());
			assertEquals(i+50, it.next());
		}
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.listIterator method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the listIterator(int) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the listIterator method returns a list iterator of the elements in this StackAdapter (in proper sequence), starting at the specified position in this StackAdapter. 
	 * The specified index indicates the first element that would be returned by an initial call to the next method. 
	 * An initial call to the previous method would return the element with the specified index minus one.
	 * In particular if the index is out of range {@code(index < 0)}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to listIterator(int) method fails, this StackAdapter hasn't changed.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to listIterator(int) method fails, this StackAdapter hasn't changed.
	 * IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testListIteratorIndexOutOfBoundsException1() {
		longStack.listIterator(-1);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.listIterator method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the listIterator(int) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the listIterator method returns a list iterator of the elements in this StackAdapter (in proper sequence), starting at the specified position in this StackAdapter. 
	 * The specified index indicates the first element that would be returned by an initial call to the next method. 
	 * An initial call to the previous method would return the element with the specified index minus one.
	 * In particular if the index is out of range {@code(index > size())}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to listIterator(int) method fails, this StackAdapter hasn't changed.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to listIterator(int) method fails, this StackAdapter hasn't changed.
	 * IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testListIteratorIndexOutOfBoundsException2() {
		longStack.listIterator(longStack.size() + 1);
	}

}
