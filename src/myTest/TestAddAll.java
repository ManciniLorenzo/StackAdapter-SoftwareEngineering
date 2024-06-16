package myTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myAdapter.StackAdapter;
/**
 * TestAddAll class
 */
public class TestAddAll {

	StackAdapter emptyStack;
	StackAdapter oneStack;
	StackAdapter longStack;
	
	/**
	 * TestAddAll setUp
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
	 * Test StackAdapter.addAll method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the addAll(HCollection) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the addAll method appends all of the elements in the specified collection to the end of this StackAdapter, in the order that they are returned by the specified collection's iterator. 
	 * The behavior of this operation is unspecified if the specified collection is modified while the operation is in progress.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * After the call to addAll() method, all of the elements in the parameter collection are added to this StackAdapter.
	 * The size of this StackAdapter increases by the size of the specified collection.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The specified collection is added to this StackAdapter, no exception is thrown.
	 */
	@Test
	public void testAddAll() {
		assertTrue(emptyStack.addAll(longStack));
		assertEquals(emptyStack, longStack);
		emptyStack.clear();
		assertFalse(emptyStack.addAll(emptyStack));
		assertTrue(emptyStack.isEmpty());
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.addAll method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the addAll(HCollection) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the addAll method appends all of the elements in the specified collection to the end of this StackAdapter, in the order that they are returned by the specified collection's iterator. 
	 * The behavior of this operation is unspecified if the specified collection is modified while the operation is in progress.
	 * In particular if the specified collection is null and needs to be added to an empty StackAdapter.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to addAll(HCollection) fails, the StackAdapter hasn't changed.
	 * NullPointerException exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to addAll(HCollection) fails, the StackAdapter hasn't changed, NullPointerException exception is thrown.
	 */
	@Test(expected=NullPointerException.class)
	public void testAddAllNullPointerException1() {
		emptyStack.addAll(null);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.addAll method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the addAll(int, HCollection) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the addAll(int, HCollection) method inserts all of the elements in the specified collection into this StackAdapter at the specified position. 
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). 
	 * The new elements will appear in this list in the order that they are returned by the specified collection's iterator. 
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * oneStack contains only one element.
	 * longStack contains 100 elements.
	 * 
	 * <h4>Post-Condition</h4>
	 * After the call to addAll(int, HCollection) method, all of the elements in the parameter collection are added to this StackAdapter, starting from the specified index.
	 * The size of this StackAdapter increases by the size of the specified collection.
	 * No exception is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The specified collection is added to this StackAdapter, no exception is thrown.
	 */
	@Test
	public void testAddAllParam() {
		assertTrue(emptyStack.addAll(0,oneStack));
		assertEquals(emptyStack, oneStack);
		emptyStack.clear();
		assertFalse(emptyStack.addAll(0, emptyStack));
		assertTrue(emptyStack.isEmpty());
		assertTrue(emptyStack.addAll(0, longStack));
		
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.addAll method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the addAll(int, HCollection) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the addAll method inserts all of the elements in the specified collection into this StackAdapter at the specified position. 
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). 
	 * The new elements will appear in this list in the order that they are returned by the specified collection's iterator. 
	 * In particular if the index is out of range {@code(index < 0)}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to addAll(int, HCollection) fails, the StackAdapter hasn't changed.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to addAll(int, HCollection) fails, the StackAdapter hasn't changed.
	 * IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddAllIndexOutOfBoundsException1() {
		emptyStack.addAll(-1, oneStack);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.addAll method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the addAll(int, HCollection) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the addAll method inserts all of the elements in the specified collection into this StackAdapter at the specified position. 
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). 
	 * The new elements will appear in this list in the order that they are returned by the specified collection's iterator. 
	 * In particular if the index is out of range {@code(index > size())}.
	 * 
	 * <h4>Pre-Condition</h4>
	 * emptyStack needs to be empty.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to addAll(int, HCollection) fails, the StackAdapter hasn't changed.
	 * IndexOutOfBoundsException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to addAll(int, HCollection) fails, the StackAdapter hasn't changed.
	 * IndexOutOfBoundsException is thrown.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testAddAllIndexOutOfBoundsException2() {
		emptyStack.addAll(emptyStack.size()+1, oneStack);
	}
	
	/**
	 * <h4>Summary</h4>
	 * Test StackAdapter.addAll method
	 * 
	 * <h4>Test Case Design</h4>
	 * This test verifies the proper functioning of the addAll(int, HCollection) method of the StackAdapter.
	 * 
	 * <h4>Test Description</h4>
	 * This test verifies that the addAll method inserts all of the elements in the specified collection into this StackAdapter at the specified position. 
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). 
	 * The new elements will appear in this list in the order that they are returned by the specified collection's iterator. 
	 * In particular if the specified collection is null.
	 * 
	 * <h4>Pre-Condition</h4>
	 * oneStack contains only one element.
	 * 
	 * <h4>Post-Condition</h4>
	 * The call to addAll(int, HCollection) fails, the StackAdapter hasn't changed.
	 * NullPointerException is thrown.
	 * 
	 * <h4>Expected Result</h4>
	 * The call to addAll(int, HCollection) fails, the StackAdapter hasn't changed.
	 * NullPointerException is thrown.
	 */
	@Test(expected=NullPointerException.class)
	public void testAddAllNullPointerException2() {
		oneStack.addAll(1,null);
	}
}
